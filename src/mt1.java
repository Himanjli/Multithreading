
class A implements Runnable 
{ 
    public void run() 
    { 
    	System.out.println("Thread A started"); 
        try
        { 

        	for(int i= 1 ; i<= 1500; i++) {
    			System.out.print("A");
    		}
        	
        	Thread.sleep(5000);
        } 
        catch (Exception e) 
        {  
        	
            System.out.println("Exception in A"); 
        } 
    } 
} 


class B extends Thread 
{ 
    public void run() 
    { 
    	System.out.println("Thread B started"); 
        try
        { 
        	for(int i= 1 ; i<= 1500; i++) {
    			System.out.print("B");
    		}
        	Thread.sleep(5000);
    
        } 
        catch (Exception e) 
        { 

            System.out.println ("Exception in B"); 
        } 
    } 
} 


class mt1
{ 
    public static void main(String[] args) throws InterruptedException
    { 
    	long start = System.currentTimeMillis();
 
        
        System.out.println("Main method running");
        
        for(int i= 1 ; i<= 1500; i++) {
			System.out.print("C");
		}
        
        
        try {
        	Thread.sleep(2000);
        	} 
        catch (InterruptedException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        	}

 
             Thread obj1 = new Thread(new A()); 
            obj1.start(); 
            Thread obj2 = new Thread(new B());
            obj2.start();
            obj1.join();
            obj2.join();
            
        System.out.println("Main method ends");
            
        
        System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start)/1000);
        
        
    } 
} 