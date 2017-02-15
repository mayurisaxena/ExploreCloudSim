package work3;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.cloudbus.cloudsim.Cloudlet;


import org.cloudbus.cloudsim.CloudletSchedulerTimeShared;
import org.cloudbus.cloudsim.Datacenter;
import org.cloudbus.cloudsim.DatacenterCharacteristics;
import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.Log;
import org.cloudbus.cloudsim.Pe;
import org.cloudbus.cloudsim.Storage;
import org.cloudbus.cloudsim.UtilizationModel;
import org.cloudbus.cloudsim.UtilizationModelFull;
import org.cloudbus.cloudsim.UtilizationModelStochastic;
import org.cloudbus.cloudsim.Vm;
import org.cloudbus.cloudsim.VmAllocationPolicySimple;
import org.cloudbus.cloudsim.VmSchedulerTimeShared;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.provisioners.BwProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;


public class MyTest {
	public static ArrayList<Vm> vmlist;
	public static ArrayList<MyCloudlet> cloudletList;
	public static MyDatacenterBroker broker;
	public static int hostNumber=1;
	
	public static void main(String[] args) {
		Log.printLine("Starting CloudSimExample1...");
		try {
			int num_user = 1; // number of cloud users
			Calendar calendar = Calendar.getInstance();
			boolean trace_flag = false; // mean trace events
			CloudSim.init(num_user, calendar, trace_flag);
			@SuppressWarnings("unused")
			Datacenter datacenter0 = createDatacenter("Datacenter_0");
			broker = createBroker();
			int brokerId = broker.getId();

			vmlist = new ArrayList<Vm>();
			int mips = 100;
			long size = 10000; // image size (MB)
			int ram = 512; // vm memory (MB)
			long bw = 1000;
			int pesNumber = 1; // number of cpus
			String vmmachine = "Xen"; // VMM name
			Vm vm = new Vm(0, brokerId,1000, pesNumber, ram, bw, size, vmmachine, new RR3());
			Vm vm2 = new Vm(1, brokerId, 5000, pesNumber, ram, bw, size, vmmachine, new RR3());
			//vmid++;
			Vm vm3 = new Vm(2, brokerId, 9000, pesNumber, ram, bw, size, vmmachine,new RR3());
			vmlist.add(vm);
			vmlist.add(vm2);
			vmlist.add(vm3);
			
			broker.submitVmList(vmlist);
			
			cloudletList = new ArrayList<MyCloudlet>();
			long length = 4000;
			long fileSize = 300;
			long outputSize = 300;
			double startTime[]={5.0,6.0,1500};
			UtilizationModel utilizationModel = new UtilizationModelFull();
			MyCloudlet cloudlet1 = new MyCloudlet(0, 5000, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,startTime[0]);
			MyCloudlet cloudlet2 = new MyCloudlet(1, 3000, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,startTime[0]);
			MyCloudlet cloudlet3 = new MyCloudlet(2, 10050, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,startTime[0]);
			MyCloudlet cloudlet4 = new MyCloudlet(3, 50000, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,startTime[0]);
			MyCloudlet cloudlet5 = new MyCloudlet(4, 1000, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,startTime[0]);
			
			cloudlet1.setUserId(brokerId);
			cloudlet2.setUserId(brokerId);
			cloudlet3.setUserId(brokerId);
			cloudlet4.setUserId(brokerId);
			cloudlet5.setUserId(brokerId);
			
			cloudlet1.setVmId(0);
			cloudlet2.setVmId(0);
			cloudlet3.setVmId(0);
			cloudlet4.setVmId(0);
			cloudlet5.setVmId(0);
			
			
			cloudletList.add(cloudlet1);
			cloudletList.add(cloudlet2);
			cloudletList.add(cloudlet3);

			cloudletList.add(cloudlet4);

			cloudletList.add(cloudlet5);
			broker.submitCloudletList(cloudletList);
			
			//broker.bindCloudletToVm(cloudlet1, vm);
			
			
			//allocateCloudletQueue (cloudletList , vmlist, broker);
			
			
			
			CloudSim.startSimulation();
			CloudSim.stopSimulation();

			List<MyCloudlet> newList = broker.getCloudletReceivedList();
			printCloudletList(newList);
//			datacenter0.printDebts();
			Log.printLine("Example_FT finished!");
		} catch (Exception e) {
			e.printStackTrace();
			Log.printLine("EXAMPLE_FT: Unwanted errors happen");
		}
	}
	
	
	
	private static void allocateCloudletQueue (List<MyCloudlet> cl , List<Vm> vm , MyDatacenterBroker broker)
	{
		int c , v ;
		c = cl.size();
		v = vm.size();
		int j= 0;
		
		for (int i= 0 ; i< c ; i++)
		{
			MyCloudlet c1 = cl.get(i);
			for (int k= i ; k<c; k++)
			{
				
				MyCloudlet c2 = cl.get(k);
				if (c1.getCloudletTotalLength() > c2.getCloudletTotalLength())
				{
					MyCloudlet temp = c1;
					cl.set(i, c2);
					cl.set(k, temp);
					c1 = cl.get(i);
				}
				
			}
			
		}
		
	//	for (int i=0;i<c;i++)
		//	System.out.println ("Length : " + cl.get(i).getCloudletTotalLength());
			

		for (int i=0; i<v ;i++)
		{
			Vm v1= vm.get(i);
			for (int k=i;k<v;k++)
			{
				Vm v2 = vm.get(k);
				if (v2.getMips() < v1.getMips())
				{
					Vm temp = v1;
					vm.set(i, v2);
					vm.set(k, temp);
					v1=vm.get(i);
					
				}
				
			}
			
			
		}  
	//	for (int i=0;i<v;i++)
		//	System.out.println ("MIPS : " + vm.get(i).getMips());
		
		
		int g =0;
		int i =0;
		
		while (i<c)
		{
			MyCloudlet c1 = cl.get(i);
			for ( g=0; g<v;g++)
			{
				Vm v1 = vm.get(g);
				
				if (c1.getCloudletTotalLength() < 5000 && v1.getMips() <=1000)
				{
					broker.bindCloudletToVm(c1.getCloudletId(),v1.getId());
					System.out.println("Inner for loop 1st: " + v1.getMips());
					i++; 
					break;
				}
				else if (c1.getCloudletTotalLength() < 10000 && v1.getMips() <=5000 && v1.getMips()>1000 && c1.getCloudletTotalLength()>=5000)
				{
					broker.bindCloudletToVm(c1.getCloudletId(),v1.getId());
					System.out.println("Inner for loop 2nd: " + i + "   "+v1.getMips());
					i++;
					break;
				}
				else if (v1.getMips() <=10000 && v1.getMips()>5000 && c1.getCloudletTotalLength()>=10000)
				{
					broker.bindCloudletToVm(c1.getCloudletId(),v1.getId());
					System.out.println("Inner for loop 3rd: " + i+ "  " + v1.getMips());
					//cl.remove(i);
					i++;
					break;
				}
				
				
				System.out.println("Inner loop : " + i);
			}
			g=0;
		}
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static Datacenter createDatacenter(String name)
	{
		List<Host> hostList = new ArrayList<Host>();
		int mips = 12000;
		int ram = 10048; // host memory (MB)
		long storage = 1000000; // host storage
		int bw = 100000;
		for (int i = 0; i < hostNumber; i++)
		{
			List<Pe> pes = new ArrayList<Pe>();
			pes.add(new Pe(0, new PeProvisionerSimple(mips))); 
			pes.add(new Pe(1, new PeProvisionerSimple(mips))); 
			pes.add(new Pe(2, new PeProvisionerSimple(mips))); 
			hostList.add(
					new Host(
						i,
						new RamProvisionerSimple(ram),
						new BwProvisionerSimple(bw),
						storage,
						pes,
						new VmSchedulerTimeShared(pes)
					)
				);
			
		}
		String arch = "x86"; // system architecture
		String os = "Linux"; // operating system
		String vmm = "Xen";
		double time_zone = 10.0; // time zone this resource located
		double cost = 3.0; // the cost of using processing in this resource
		double costPerMem = 0.05; // the cost of using memory in this resource
		double costPerStorage = 0.001; // the cost of using storage in this
										// resource
		double costPerBw = 0.0; // the cost of using bw in this resource
		LinkedList<Storage> storageList = new LinkedList<Storage>(); // we are not adding SAN
													// devices by now

		DatacenterCharacteristics characteristics = new DatacenterCharacteristics(
				arch, os, vmm, hostList, time_zone, cost, costPerMem,
				costPerStorage, costPerBw);

		Datacenter datacenter = null;
		try {
			datacenter = new Datacenter(name,
					characteristics, 
					new VmAllocationPolicySimple(hostList), 
					storageList,
					5.0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return datacenter;
	}
	private static MyDatacenterBroker createBroker() {
		MyDatacenterBroker broker = null;
		try
		{
		
			broker = new MyDatacenterBroker("Broker");
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return broker;
	}
	private static void printCloudletList(List<MyCloudlet> list) {
		int size = list.size();
		Cloudlet cloudlet;

		String indent = "    ";
		Log.printLine();
		Log.printLine("========== OUTPUT ==========");
		Log.printLine("Cloudlet ID" + indent + "STATUS" + indent
				+ "Data center ID" + indent + "VM ID" + indent + "Time" + indent
				+ "Start Time" + indent + "Finish Time");

		DecimalFormat dft = new DecimalFormat("###.##");
		for (int i = 0; i < size; i++) {
			cloudlet = list.get(i);
			Log.print(indent + cloudlet.getCloudletId() + indent + indent);

			if (cloudlet.getCloudletStatus() == Cloudlet.SUCCESS) {
				Log.print("SUCCESS");

				Log.printLine(indent + indent + cloudlet.getResourceId()
						+ indent + indent + indent + cloudlet.getVmId()
						+ indent + indent
						+ dft.format(cloudlet.getActualCPUTime()) + indent
						+ indent + dft.format(cloudlet.getExecStartTime())
						+ indent + indent
						+ dft.format(cloudlet.getFinishTime()));
			}
		}
	}
}
