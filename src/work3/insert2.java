package work3;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.Datacenter;
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
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.provisioners.BwProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;

import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.ActionSupport;


import work3.RR3;
import work3.CloudletSpace;
import work3.CloudletTime;
import work3.MyDatacenterBroker;


public   class insert2 extends ActionSupport {
	
	 private long length1,length2,length3,length4,length5,length6,length7,length8,length9,length10;
	 private double start1,start2,start3,start4,start5,start6,start7,start8,start9,start10;
	 public static List <Long> len =  new ArrayList<Long>(10) ;
	 public static List <Double> st =  new ArrayList<Double>(10) ;
	 
	 
	 public static List <Double> finishTime =  new ArrayList<Double>(25) ;
		public static List <Double> executionTime =  new ArrayList<Double>(25) ;
		
		public static List <Integer> cloudletId =  new ArrayList<Integer>(25) ;
		public static List <Integer> vmId =  new ArrayList<Integer>(25) ;
		public static List <Double> startTime =  new ArrayList<Double>(25) ;
	 
	 
	 

	   public String execute() throws Exception {
		  len.add(getLength1()); 
		  len.add(getLength2()); 
		  len.add(getLength3()); 
		  len.add(getLength4()); 
		  len.add(getLength5()); 
		  len.add(getLength6()); 
		  len.add(getLength7()); 
		  len.add(getLength8()); 
		  len.add(getLength9()); 
		  len.add(getLength10()); 
		  st.add(getStart1());
		  st.add(getStart2());
		  st.add(getStart3());
		  st.add(getStart4());
		  st.add(getStart5());
		  st.add(getStart6());
		  st.add(getStart7());
		  st.add(getStart8());
		  st.add(getStart9());
		  st.add(getStart10());
		  
		implement(len, st);
	      
		  return "success";
	   }
	   
	   public long getLength1() {
	      return length1;
	   }

	   public void setLength1(long length1) {
	      this.length1 = length1;
	   }
	   
	   public long getLength2() {
		      return length2;
	   }

	   public void setLength2(long length2) {
		      this.length2 = length2;
	   }
	
	   public long getLength3() {
		      return length3;
	   }
	   
	   public void setLength3(long length3) {
		      this.length3 = length3;
	   }

		public void setLength4(long length4) {
		      this.length4 = length4;
	   }
		
	   public long getLength4() {
		      return length4;
	   }

	   public long getLength5() {
		      return length5;
	   }
		public void setLength5(long length5) {
		      this.length5 = length5;
		}
		
		 public long getLength6() {
		      return length6;
	   }
		public void setLength6(long length6) {
		      this.length6 = length6;
		}
		
		 public long getLength7() {
		      return length7;
	   }
		public void setLength7(long length7) {
		      this.length7 = length7;
		}
	   
		 public long getLength8() {
		      return length8;
	   }
		public void setLength8(long length8) {
		      this.length8 = length8;
		}
		
		 public long getLength9() {
		      return length9;
	   }
		public void setLength9(long length9) {
		      this.length9 = length9;
		}		
		
		 public long getLength10() {
		      return length10;
	   }
		public void setLength10(long length10) {
		      this.length10 = length10;
		}
		
		
		
		   public double getStart1() {
			      return start1;
			   }

			   public void setStart1(double start1) {
			      this.start1 = start1;
			   }
			   
			   public double getStart2() {
				      return start2;
				   }
			   
			   public void setStart2(double start2) {
				      this.start2 = start2;
			   }
			
			   public double getStart3() {
				      return start3;
				   }
			   
			   public void setStart3(double start3) {
				      this.start3 = start3;
			   }

				public void setStart4(double start4) {
				      this.start4 = start4;
			   }
				
				 public double getStart4() {
				      return start4;
				   }
				 
				 public double getStart5() {
				      return start5;
				   }
				public void setStart5(double start5) {
				      this.start5 = start5;
				}
				
				 public double getStart6() {
				      return start6;
				   }
				 
				public void setStart6(double start6) {
				      this.start6 = start6;
				}
				
				 public double getStart7() {
				      return start7;
				   }
				 
				public void setStart7(double start7) {
				      this.start7 = start7;
				}
			   
				 public double getStart8() {
				      return start8;
				   }
				 
				public void setStart8(double start8) {
				      this.start8 = start8;
				}
				
				 public double getStart9() {
				      return start9;
				   }
				 
				 public void setStart9(double start9) {
				      this.start9 = start9;
				}	
				
				 public double getStart10() {
				      return start10;
				   }
				 
				public void setStart10(double start10) {
				      this.start10 = start10;
				}
		
				
				public void setExecutionTime(List<Double> list)
				{
					executionTime.addAll(list);
				}
				
				public List<Double> getExecutionTime()
				{
					return executionTime;
				}
				
				
				
				public void setStartTIme(List<Double> list)
				{
					startTime.addAll(list);
				}
				
				public List<Double> getStartTime()
				{
					return startTime;
				}
				
				
				public void setFinishTIme(List<Double> list)
				{
					finishTime.addAll(list);
				}
				
				public List<Double> getFinishTime()
				{
					return finishTime;
				}
				
				
				public List<Integer> getCloudletId()
				{return cloudletId;}
				
				public void setCloudletId(List<Integer> list)
				{
					cloudletId.addAll(list);
				}
				
				
				public List<Integer> getVmId()
				{return vmId;}
				
				public void setVmId(List<Integer> list)
				{
					vmId.addAll(list);
				}
				
		
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				private static List<MyCloudlet> cloudletList;

				/** The vmlist. */
				private static List<Vm> vmlist;
				
				public static double totalF=0;       //total finish time
				public static double totalR=0;		//total response time
				
				
				public static List <Double> ResponseTime =  new ArrayList<Double>(25) ;
				
				public static List <Double> sendfinishTime =  new ArrayList<Double>(25) ;
				
				
				
				public static MyDatacenterBroker broker;
				
				
				public static RR3 v1 = new RR3();
				//CloudletTime v1 = new CloudletTime();
				
				public static CloudletTime v2 = new CloudletTime();
				public static CloudletSpace v3 = new CloudletSpace();
				
				
				public  void implement(List<Long> length, List<Double> start) {

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
						broker =  createBroker();
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
						
						
						
						
								
						
						
						
						
						//create VMs
						Vm vm1 = new Vm(vmid, brokerId,5000, pesNumber, ram, bw, size, vmm, v1);
						vmid++;
						Vm vm2 = new Vm(vmid, brokerId, 1000, pesNumber, ram, bw, size, vmm, v2);
						vmid++;
						Vm vm3 = new Vm(vmid, brokerId, 10000, pesNumber, ram, bw, size, vmm, v3);
						
						if (vm1== null || v1 == null)
						{
							System.out.println("No VM");
							
						}
						
						
						//add the VMs to the vmList
						vmlist.add(vm1);
						vmlist.add(vm2);
						vmlist.add(vm3);
						

						//submit vm list to the broker
						broker.submitVmList(vmlist);


						//Fifth step: Create two Cloudlets
						cloudletList = new ArrayList<MyCloudlet>();

						//Cloudlet properties
						int id = 0;
						//long length = 10000;
						long fileSize = 30;
						long outputSize = 30;
						UtilizationModel utilizationModel = new UtilizationModelFull();

						MyCloudlet cloudlet1 = new MyCloudlet(id, length.get(0), pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,start.get(0));
						cloudlet1.setUserId(brokerId);

						id++;
						MyCloudlet cloudlet2 = new MyCloudlet(id,length.get(1), pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,start.get(1));
						cloudlet2.setUserId(brokerId);

						id++;
						MyCloudlet cloudlet3 = new MyCloudlet(id, length.get(2), pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,start.get(2));
						cloudlet3.setUserId(brokerId);
						
						id++;
						MyCloudlet cloudlet4 = new MyCloudlet(id, length.get(3), pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,start.get(3));
						cloudlet4.setUserId(brokerId);
						
						id++;
						MyCloudlet cloudlet5 = new MyCloudlet(id, length.get(4), pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,start.get(4));
						cloudlet5.setUserId(brokerId);
						
						id++;
						MyCloudlet cloudlet6 = new MyCloudlet(id, length.get(5), pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,start.get(5));
						cloudlet6.setUserId(brokerId);
						
						id++;
						MyCloudlet cloudlet7 = new MyCloudlet(id, length.get(6), pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,start.get(6));
						cloudlet7.setUserId(brokerId);
						
						id++;
						MyCloudlet cloudlet8 = new MyCloudlet(id, length.get(7), pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,start.get(7));
						cloudlet8.setUserId(brokerId);
						
						id++;
						MyCloudlet cloudlet9 = new MyCloudlet(id, length.get(8), pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,start.get(8));
						cloudlet9.setUserId(brokerId);
						
						id++;
						MyCloudlet cloudlet10 = new MyCloudlet(id, length.get(9), pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,start.get(9));
						cloudlet10.setUserId(brokerId);
						/*
						id++;
						MyCloudlet cloudlet11 = new MyCloudlet(id, 48000, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,12);
						cloudlet11.setUserId(brokerId);

						id++;
						MyCloudlet cloudlet12 = new MyCloudlet(id,150000, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel,10);
						cloudlet12.setUserId(brokerId);
						*/
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
						//cloudletList.add(cloudlet11);
						//cloudletList.add(cloudlet12);


						//submit cloudlet list to the broker
						broker.submitCloudletList(cloudletList);


						
						//allocateCloudlet (cloudletList , vmlist, broker);
						
						allocateCloudletQueue (cloudletList , vmlist, broker);
						
						
						
						// Sixth step: Starts the simulation
						CloudSim.startSimulation();


						// Final step: Print results when simulation is over
						List<Cloudlet> newList = broker.getCloudletReceivedList();

						CloudSim.stopSimulation();

			        	//printCloudletList(newList);
			        	
						
			        	display(v1);
			        	display(v2);
			        	display(v3);
			        	
			        	
			        	
			        	this.cloudletDisplay (newList);

						Log.printLine("Efficient Scheduling with load balancing finished!!!");
					}
					catch (Exception e) {
						e.printStackTrace();
						Log.printLine("The simulation has been terminated due to an unexpected error");
					}
					
					
					return;
					
				}
				
				private static void allocateCloudlet (List<MyCloudlet> cl , List<Vm> vm , MyDatacenterBroker broker)
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
					
					for (int i=0;i<c;i++)
						System.out.println ("Length : " + cl.get(i).getCloudletTotalLength());
						
			
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
						Cloudlet c1 = cl.get(i);
						for ( g=0; g<v;g++)
						{
							Vm v1 = vm.get(g);
							
							if (c1.getCloudletTotalLength() < 10000 && v1.getMips() <=1000)
							{
								broker.bindCloudletToVm(c1.getCloudletId(),v1.getId());
								System.out.println("Inner for loop 1st: " + v1.getMips());
								i++;
								break;
							}
							else if (c1.getCloudletTotalLength() < 50000 && v1.getMips() <=5000 && v1.getMips()>1000 && c1.getCloudletTotalLength()>=10000)
							{
								broker.bindCloudletToVm(c1.getCloudletId(),v1.getId());
								System.out.println("Inner for loop 2nd: " + i + "   "+v1.getMips());
								i++;
								break;
							}
							else if (v1.getMips() <=10000 && v1.getMips()>5000 && c1.getCloudletTotalLength()>=50000)
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
					while (i<25)
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
					while (i<25)
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
				
				public  void cloudletDisplay (List<Cloudlet> list)
				{
					int size = list.size();
					Cloudlet cloudlet;
					
					cloudletId = new ArrayList<Integer>();
					vmId = new ArrayList<Integer>();
					sendfinishTime = new ArrayList<Double>();
					executionTime = new ArrayList<Double>();
					startTime = new ArrayList<Double>();
					
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
									indent + indent + dft.format(finishTime.get(cloudlet.getCloudletId())-ResponseTime.get(cloudlet.getCloudletId())) + indent + indent + indent + dft.format(ResponseTime.get(cloudlet.getCloudletId()))+
									indent + indent + dft.format(finishTime.get(cloudlet.getCloudletId())));
						}
						
						cloudletId.add(cloudlet.getCloudletId());
						vmId.add(cloudlet.getVmId());
						startTime.add(cloudlet.getSubmissionTime());
						sendfinishTime.add(finishTime.get(cloudlet.getCloudletId()));
						executionTime.add(finishTime.get(cloudlet.getCloudletId())-ResponseTime.get(cloudlet.getCloudletId()));
						
						
					}

					Log.printLine("Average Turn around time :  " + avF);
					Log.printLine("Average Response time :  " + avR);
					
					//insert2 obj = new insert2();
					
//					obj.setCloudletId(cloudletId);
			//		obj.setExecutionTIme(executionTime);
				//	obj.setFinishTIme(sendfinishTime);
					//obj.setVmId(vmId);
			//		obj.setStartTIme(startTime);
					
					
					setCloudletId(cloudletId);
					setExecutionTime(executionTime);
					setFinishTIme(sendfinishTime);
					setVmId(vmId);
					setStartTIme(startTime);
					
					
								
					
				}
				
		
}
