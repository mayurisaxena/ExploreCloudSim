package work3;
import java.util.ArrayList;

import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.DatacenterBroker;
import org.cloudbus.cloudsim.Log;
import org.cloudbus.cloudsim.Vm;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.core.CloudSimTags;
import org.cloudbus.cloudsim.lists.VmList;


public class MyDatacenterBroker extends DatacenterBroker{
	// I think this is a bug in Cloudsim2.2.1 
	//that cloudletsSubmitted is private instead of being protected 
	protected int cloudletsSubmitted;
	public MyDatacenterBroker(String name) throws Exception {
		super(name);
		// TODO Auto-generated constructor stub
		setCloudletList(new ArrayList<MyCloudlet>());
		setCloudletSubmittedList(new ArrayList<MyCloudlet>());
		setCloudletReceivedList(new ArrayList<MyCloudlet>());

	}
	@Override
	protected void submitCloudlets() {
		int vmIndex = 0;
		for (Cloudlet cloudlet : getCloudletList()) {
			MyCloudlet myCloudlet = (MyCloudlet) cloudlet;
			Vm vm;
			if (cloudlet.getVmId() == -1) { //if user didn't bind this cloudlet and it has not been executed yet
				vm = getVmsCreatedList().get(vmIndex);
			} else { //submit to the specific vm
				vm = VmList.getById(getVmsCreatedList(), cloudlet.getVmId());
				
		/*		double currentCPU = vm.getTotalUtilizationOfCpu(CloudSim.clock());
                //TO-DO -> Use currentCPU to your business rules...
                //This will be done after you send each cloudlet
                System.out.println("Cloudlet: " + cloudlet.getCloudletId() + " - VM: " + vm.getId() + " - Current CPU Usage Percent: " + currentCPU*100);
*/
					
				
				
				if (vm == null) { // vm was not created
					Log.printLine(CloudSim.clock()+": "+getName()+ ": Postponing execution of cloudlet "+cloudlet.getCloudletId()+": bount VM not available");
					continue;
				}
			}

			Log.printLine(myCloudlet.getStartTime()+": "+getName()+ ": Sending cloudlet "+cloudlet.getCloudletId()+" to VM #"+vm.getId());
			cloudlet.setVmId(vm.getId());
			//sendNow(getVmsToDatacentersMap().get(vm.getId()), CloudSimTags.CLOUDLET_SUBMIT, cloudlet);
			send(getVmsToDatacentersMap().get(vm.getId()),myCloudlet.getStartTime() ,CloudSimTags.CLOUDLET_SUBMIT, myCloudlet);
			cloudletsSubmitted++;
			vmIndex = (vmIndex + 1) % getVmsCreatedList().size();
			getCloudletSubmittedList().add(cloudlet);
		}

		// remove submitted cloudlets from waiting list
		for (Cloudlet cloudlet : getCloudletSubmittedList()) {
			getCloudletList().remove(cloudlet);
		}
	}
	
}
