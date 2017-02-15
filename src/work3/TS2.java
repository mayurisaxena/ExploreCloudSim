package work3;

// cloudlets changed and mips changed

	import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

	import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.CloudletSchedulerTimeShared;
import org.cloudbus.cloudsim.CloudletSchedulerSpaceShared;
import org.cloudbus.cloudsim.Datacenter;
import org.cloudbus.cloudsim.DatacenterBroker;
import org.cloudbus.cloudsim.DatacenterCharacteristics;
import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.Log;
import org.cloudbus.cloudsim.Pe;
import org.cloudbus.cloudsim.Storage;
import org.cloudbus.cloudsim.UtilizationModel;
import org.cloudbus.cloudsim.UtilizationModelFull;
import org.cloudbus.cloudsim.Vm;
import org.cloudbus.cloudsim.VmAllocationPolicySimple;
import org.cloudbus.cloudsim.VmSchedulerSpaceShared;
import org.cloudbus.cloudsim.VmSchedulerTimeShared;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.provisioners.BwProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;
	




//import work.RRcloudScheduler1;
import work.RR2;

	public class TS2 {

		private static List<MyCloudlet> cloudletList;

		/** The vmlist. */
		private static List<Vm> vmlist;
		
		public static double totalF=0;       //total finish time
		public static double totalR=0;		//total response time
		
		public static List <Double> finishTime =  new ArrayList<Double>(25) ;
		public static List <Double> ResponseTime =  new ArrayList<Double>(25) ;
		
		public static void main(String[] args) {

			Log.printLine("Starting ImplementRR...");
			for (int i = 0; i < 25; i++) {
				finishTime.add(0.0);
				ResponseTime.add(0.0);
			}

			try {
				// First step: Initialize the CloudSim package. It should be called
				// before creating any entities.
				int num_user = 1;   // number of cloud users
				Calendar calendar = Calendar.getInstance();
				boolean trace_flag = false;  // mean trace events

				// Initialize the GridSim library
				CloudSim.init(num_user, calendar, trace_flag);

				// Second step: Create Datacenters
				//Datacenters are the resource providers in CloudSim. We need at list one of them to run a CloudSim simulation
				@SuppressWarnings("unused")
				Datacenter datacenter0 = createDatacenter("Datacenter_0");
				

				//Third step: Create Broker
				MyDatacenterBroker broker = createBroker();
				int brokerId = broker.getId();

				//Fourth step: Create one virtual machine
				vmlist = new ArrayList<Vm>();

				//VM description
				int vmid = 0;
				int mips = 500;
				long size = 10000; //image size (MB)
				int ram = 512; //vm memory (MB)
				long bw = 1000;
				int pesNumber = 1; //number of cpus
				String vmm = "Xen"; //VMM name

				//create scheduling objects for VM
				RR3 v1 = new RR3();
				RR3 v2 = new RR3();
				CloudletSpace v3 = new CloudletSpace();
				CloudletSpace v4 = new CloudletSpace();
				CloudletTime v5 = new CloudletTime();
				CloudletTime v6 = new CloudletTime();
				CloudletTime v7 = new CloudletTime();
				
				
				
						
				
				
				
				
				//create VMs
				Vm vm1 = new Vm(vmid, brokerId, mips, pesNumber, ram, bw, size, vmm, v1);
				vmid++;
				Vm vm2 = new Vm(vmid, brokerId, mips, pesNumber, ram, bw, size, vmm, v2);
				
				vmid++;
				Vm vm3 = new Vm(vmid, brokerId, mips, pesNumber, ram, bw, size, vmm, v3);
				
				vmid++;
				Vm vm4 = new Vm(vmid, brokerId, mips, pesNumber, ram, bw, size, vmm,v4);
				
				vmid++;
				Vm vm5 = new Vm(vmid, brokerId, 1000, pesNumber, ram, bw, size, vmm,v5);
				
				vmid++;
				Vm vm6 = new Vm(vmid, brokerId, 5000, pesNumber, ram, bw, size, vmm, v6);
				vmid++;
				Vm vm7 = new Vm(vmid, brokerId, 10000, pesNumber, ram, bw, size, vmm, v7);
				
				
				
				//add the VMs to the vmList
				//vmlist.add(vm1);
				//vmlist.add(vm2);
				//vmlist.add(vm3);
				//vmlist.add(vm4);
				vmlist.add(vm5);
				vmlist.add(vm6);
				vmlist.add(vm7);


				//submit vm list to the broker
				broker.submitVmList(vmlist);


				//Fifth step: Create two Cloudlets
				cloudletList = new ArrayList<MyCloudlet>();

				//Cloudlet properties
				int id = 0;
				long length = 10000;
				long fileSize = 30;
				long outputSize = 30;
				UtilizationModel utilizationModel = new UtilizationModelFull();

				MyCloudlet cloudlet1 = new MyCloudlet(id, 8000, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,9.6);
				cloudlet1.setUserId(brokerId);

				id++;
				MyCloudlet cloudlet2 = new MyCloudlet(id,35000, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,8.5);
				cloudlet2.setUserId(brokerId);

				id++;
				MyCloudlet cloudlet3 = new MyCloudlet(id, 70000, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,13);
				cloudlet3.setUserId(brokerId);
				
				id++;
				MyCloudlet cloudlet4 = new MyCloudlet(id, 9000, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,7.8);
				cloudlet4.setUserId(brokerId);
				
				id++;
				MyCloudlet cloudlet5 = new MyCloudlet(id, 37500, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,4.5);
				cloudlet5.setUserId(brokerId);
				
				id++;
				MyCloudlet cloudlet6 = new MyCloudlet(id, 90000, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,11.5);
				cloudlet6.setUserId(brokerId);
				
				id++;
				MyCloudlet cloudlet7 = new MyCloudlet(id, 9500, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,5.6);
				cloudlet7.setUserId(brokerId);
				
				id++;
				MyCloudlet cloudlet8 = new MyCloudlet(id, 45000, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,7.2);
				cloudlet8.setUserId(brokerId);
				
				id++;
				MyCloudlet cloudlet9 = new MyCloudlet(id, 120000, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,9.5);
				cloudlet9.setUserId(brokerId);
				
				id++;
				MyCloudlet cloudlet10 = new MyCloudlet(id, 9800, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,11);
				cloudlet10.setUserId(brokerId);
				
				id++;
				MyCloudlet cloudlet11 = new MyCloudlet(id, 48000, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,12);
				cloudlet11.setUserId(brokerId);

				id++;
				MyCloudlet cloudlet12 = new MyCloudlet(id,150000, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,10);
				cloudlet12.setUserId(brokerId);	
				
				
				//add the cloudlets to the list
				cloudletList.add(cloudlet1);
				cloudletList.add(cloudlet2);
				cloudletList.add(cloudlet3);
				cloudletList.add(cloudlet4);
				cloudletList.add(cloudlet5);
				cloudletList.add(cloudlet6);
				cloudletList.add(cloudlet7);
				cloudletList.add(cloudlet8);
				cloudletList.add(cloudlet9);
				cloudletList.add(cloudlet10);
				cloudletList.add(cloudlet11);
				cloudletList.add(cloudlet12);

				//submit cloudlet list to the broker
				broker.submitCloudletList(cloudletList);


				//bind the cloudlets to the vms. This way, the broker
				// will submit the bound cloudlets only to the specific VM
				//broker.bindCloudletToVm(cloudlet1.getCloudletId(),vm1.getId());
				//broker.bindCloudletToVm(cloudlet2.getCloudletId(),vm1.getId());
				//broker.bindCloudletToVm(cloudlet3.getCloudletId(),vm1.getId());
				//broker.bindCloudletToVm(cloudlet4.getCloudletId(),vm4.getId());
				//broker.bindCloudletToVm(cloudlet5.getCloudletId(),vm5.getId());

				//allocateCloudlet (cloudletList , vmlist, broker);
				
				// Sixth step: Starts the simulation
				CloudSim.startSimulation();


				// Final step: Print results when simulation is over
				List<Cloudlet> newList = broker.getCloudletReceivedList();

				CloudSim.stopSimulation();

	        	//printCloudletList(newList);
	        	
				
	        	//display(v1);
	        	//display(v2);
	        	//display(v3);
	        	//display(v4);
	        	display(v5);
	        	display(v6);
	        	display(v7);
	        	
	        	cloudletDisplay (newList);

				Log.printLine("CloudSimExample4 finished!");
			}
			catch (Exception e) {
				e.printStackTrace();
				Log.printLine("The simulation has been terminated due to an unexpected error");
			}
			
			
			
			
		}
		
		private static void shortestJobFirst (List<Cloudlet> cl , List<Vm> vm , DatacenterBroker broker)
		{
			
			//goto class ShortestJobF
			
			int c , v ;
			c = cl.size();
			v = vm.size();
			int j= 0;
			
			for (int i= 0 ; i< c ; i++)
			{
				Cloudlet c1 = cl.get(i);
				for (int k= i ; k<c; k++)
				{
					
					Cloudlet c2 = cl.get(k);
					if (c1.getCloudletTotalLength() > c2.getCloudletTotalLength())
					{
						Cloudlet temp = c1;
						cl.set(i, c2);
						cl.set(k, temp);
						c1 = cl.get(i);
					}
					
				}
				
			}
			
			for (int i=0;i<c;i++)
				System.out.println ("Length : " + cl.get(i).getCloudletTotalLength());
			
			broker.submitCloudletList(cl);
			
			int g =0;
			
			for (int i= 0 ;i<c; i++)
			{
				if (g<v)
				{
					Vm v1 = vm.get(g);
					Cloudlet c1 = cl.get(i);
					broker.bindCloudletToVm(c1.getCloudletId(),v1.getId());
					g++;				
				}
				else 
					{ g=0; 
					i--;
					}
			}
			 
		}
		
		private static void allocateCloudlet (List<Cloudlet> cl , List<Vm> vm , DatacenterBroker broker)
		{
			int c , v ;
			c = cl.size();
			v = vm.size();
			int j= 0;
			
			for (int i= 0 ; i< c ; i++)
			{
				Cloudlet c1 = cl.get(i);
				for (int k= i ; k<c; k++)
				{
					
					Cloudlet c2 = cl.get(k);
					if (c1.getCloudletTotalLength() > c2.getCloudletTotalLength())
					{
						Cloudlet temp = c1;
						cl.set(i, c2);
						cl.set(k, temp);
						c1 = cl.get(i);
					}
					
				}
				
			}
			
			for (int i=0;i<c;i++)
				System.out.println ("Length : " + cl.get(i).getCloudletTotalLength());
			
			
			
			int g =0;
			
			for (int i= 0 ;i<c; i++)
			{
				if (g<v)
				{
					Vm v1 = vm.get(g);
					Cloudlet c1 = cl.get(i);
					broker.bindCloudletToVm(c1.getCloudletId(),v1.getId());
					g++;				
				}
				else 
					{ g=0; 
					i--;
					}
			}
			 
		}

		private static Datacenter createDatacenter(String name){

			// Here are the steps needed to create a PowerDatacenter:
			// 1. We need to create a list to store
			//    our machine
			List<Host> hostList = new ArrayList<Host>();

			// 2. A Machine contains one or more PEs or CPUs/Cores.
			// In this example, it will have only one core.
			List<Pe> peList = new ArrayList<Pe>();

			int mips = 10000;

			// 3. Create PEs and add these into a list.
			peList.add(new Pe(0, new PeProvisionerSimple(mips))); // need to store Pe id and MIPS Rating
			peList.add(new Pe(1, new PeProvisionerSimple(mips)));
			peList.add(new Pe(2, new PeProvisionerSimple(mips)));
			peList.add(new Pe(3, new PeProvisionerSimple(mips)));
			peList.add(new Pe(4, new PeProvisionerSimple(mips)));
			
			
			//4. Create Host with its id and list of PEs and add them to the list of machines
			int hostId=0;
			int ram = 2048; //host memory (MB)
			long storage = 1000000; //host storage
			int bw = 10000;
			Host h1= new Host(
					hostId,
					new RamProvisionerSimple(ram),
					new BwProvisionerSimple(bw),
					storage,
					peList,
					new VmSchedulerSpaceShared(peList)
				);
			hostId++;
			Host h2= new Host(
					hostId,
					new RamProvisionerSimple(ram),
					new BwProvisionerSimple(bw),
					storage,
					peList,
					new VmSchedulerSpaceShared(peList)
				);

			//in this example, the VMAllocatonPolicy in use is SpaceShared. It means that only one VM
			//is allowed to run on each Pe. As each Host has only one Pe, only one VM can run on each Host.
			hostList.add(h1);
			hostList.add(h2);
			
			
			// This is our first machine

			// 5. Create a DatacenterCharacteristics object that stores the
			//    properties of a data center: architecture, OS, list of
			//    Machines, allocation policy: time- or space-shared, time zone
			//    and its price (G$/Pe time unit).
			String arch = "x86";      // system architecture
			String os = "Linux";          // operating system
			String vmm = "Xen";
			double time_zone = 10.0;         // time zone this resource located
			double cost = 3.0;              // the cost of using processing in this resource
			double costPerMem = 0.05;		// the cost of using memory in this resource
			double costPerStorage = 0.001;	// the cost of using storage in this resource
			double costPerBw = 0.0;			// the cost of using bw in this resource
			LinkedList<Storage> storageList = new LinkedList<Storage>();	//we are not adding SAN devices by now

		       DatacenterCharacteristics characteristics = new DatacenterCharacteristics(
		                arch, os, vmm, hostList, time_zone, cost, costPerMem, costPerStorage, costPerBw);


			// 6. Finally, we need to create a PowerDatacenter object.
			Datacenter datacenter = null;
			try {
				datacenter = new Datacenter(name, characteristics, new VmAllocationPolicySimple(hostList), storageList, 0);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return datacenter;
		}

		//We strongly encourage users to develop their own broker policies, to submit vms and cloudlets according
		//to the specific rules of the simulated scenario
		private static MyDatacenterBroker createBroker(){

			MyDatacenterBroker broker = null;
			try {
				broker = new MyDatacenterBroker("Broker");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return broker;
		}
		/**
		 * Prints the Cloudlet objects
		 * @param list  list of Cloudlets
		 */
		private static void printCloudletList(List<Cloudlet> list) {
			int size = list.size();
			Cloudlet cloudlet;

			String indent = "    ";
			Log.printLine();
			Log.printLine("========== OUTPUT ==========");
			Log.printLine("Cloudlet ID" + indent + "STATUS" + indent +
					"Data center ID" + indent + "VM ID" + indent + "Time" + indent + "Start Time" + indent + "Finish Time");

			DecimalFormat dft = new DecimalFormat("###.##");
			for (int i = 0; i < size; i++) {
				cloudlet = list.get(i);
				Log.print(indent + cloudlet.getCloudletId() + indent + indent);

				if (cloudlet.getCloudletStatus() == Cloudlet.SUCCESS){
					Log.print("SUCCESS");

					Log.printLine( indent + indent + cloudlet.getResourceId() + indent + indent + indent + cloudlet.getVmId() +
							indent + indent + dft.format(cloudlet.getActualCPUTime()) + indent + indent + dft.format(cloudlet.getExecStartTime())+
							indent + indent + dft.format(cloudlet.getFinishTime()));
				}
			}

		}
		
		public static void display (RR3 vm)
		{
			int i = 0 ;
			double avF =0 ;
			double avR =0 ;
			int c = 0;
			while (i<10)
			{
				if (vm.finishTime.get(i) > 0)
				{
				c++;
				avF = avF + vm.finishTime.get(i) ;
				finishTime.set (i,vm.finishTime.get(i));
				System.out.println("Cloudlet id :"+ i + "finish time :" + finishTime.get(i) );
				
				 }
				if (vm.ResponseTime.get(i) > 0)
				{
				
				avR = avR + vm.ResponseTime.get(i) ;
				ResponseTime.set(i, vm.ResponseTime.get(i));
				 }
				
				 i++;
			}
			totalF = totalF + avF;
			totalR = totalR + avR;
			avF = avF/c;
			avR = avR/c;
			
			
			
		}
		
		public static void display (CloudletTime vm)
		{
			int i = 0 ;
			double avF =0 ;
			double avR =0;
			int c = 0;
			while (i<25)
			{
				if (vm.finishTime.get(i) > 0)
				{
				c++;
				avF = avF + vm.finishTime.get(i) ;
				finishTime.set (i,vm.finishTime.get(i));
				 }
				if (vm.ResponseTime.get(i) > 0)
				{
				
				avR = avR + vm.ResponseTime.get(i) ;
				ResponseTime.set(i, vm.ResponseTime.get(i));
				
				 }
				 i++;
			}
			totalF = totalF + avF;
			totalR = totalR + avR;
			avF = avF/c;
			avR = avR/c;
			
			
			
		}
		
		
		public static void display (CloudletSpace vm)
		{
			int i = 0 ;
			double avF =0 ;
			double avR =0;
			int c = 0;
			while (i<10)
			{
				if (vm.finishTime.get(i) > 0)
				{
				c++;
				avF = avF + vm.finishTime.get(i) ;
				finishTime.set(i,vm.finishTime.get(i));
				
				 }
				if (vm.ResponseTime.get(i) > 0)
				{
				
				avR = avR + vm.ResponseTime.get(i) ;
				ResponseTime.set(i, vm.ResponseTime.get(i));
				 }
				 i++;
			}
			totalF = totalF + avF;
			totalR = totalR + avR;
			avF = avF/c;
			avR = avR/c;
			
			
		}
		
		public static void cloudletDisplay (List<Cloudlet> list)
		{
			int size = list.size();
			Cloudlet cloudlet;

			
			double avF = totalF/size;
			double avR = totalR/size;
			
			
			String indent = "          ";
			Log.printLine();
			Log.printLine("========== OUTPUT ==========");
			Log.printLine("Cloudlet ID" + indent + indent+ "STATUS" + indent +
					"Data center ID" + indent + "VM ID" + indent + indent + "Time" + indent + indent + indent+ "Start Time" + indent + indent+ "Finish Time");

			DecimalFormat dft = new DecimalFormat("###.##");
			for (int i = 0; i < size; i++) {
				cloudlet = list.get(i);
				Log.print(indent + cloudlet.getCloudletId() + indent + indent);

				if (cloudlet.getCloudletStatus() == Cloudlet.SUCCESS){
					Log.print("SUCCESS");

					Log.printLine( indent + indent + cloudlet.getResourceId() + indent + indent + cloudlet.getVmId() +
							indent + indent + dft.format(finishTime.get(cloudlet.getCloudletId())-ResponseTime.get(cloudlet.getCloudletId())) + indent + indent + indent + (ResponseTime.get(cloudlet.getCloudletId()))+
							indent + indent + (finishTime.get(cloudlet.getCloudletId())));
				}
			}

			Log.printLine("Average Turn around time :  " + avF);
			Log.printLine("Average Response time :  " + avR);
			
			
			
			
		}
	
		
		
		
	}

	

