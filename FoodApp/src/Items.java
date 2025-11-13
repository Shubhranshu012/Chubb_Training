import java.util.*;
public class Items {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("New 2");
		
		System.out.println(fib(7));
		//prime();
		int arr[]= {1,2,3,4,5,6};
		binary(arr,5);
		int arr2[]= {1002,110,23445,6789,9807,6455,75432};
		int k=110;
		in_sort(arr2);
		binary(arr2,6455);
		Scanner sc=new Scanner(System.in);
		String x=(sc.next());
		System.out.println(x);
	}
	public static int fib(int n) {
	    if (n == 0) return 0;
	    if (n == 1) return 1;

	    int a = 0, b = 1, c = 0;

	    for (int i = 2; i <= n; i++) {
	        c = a + b;  
	        a = b;      
	        b = c;
	    }

	    return b; 
	}

	public static void prime() {
		
		for(int i=2;i<=500;i++) {
			boolean found=true;
			for(int j=2;j*j<i;j++) {
				if(i%j==0) {
					found=false;
					break;
				}
			}
			if(found) {
				System.out.println(i);
			}
		}
	}
	public static void linear(int arr[],int k) {
		boolean found=false;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==k) {
				found=true;
				System.out.println("Found at :"+i);
			}
		}
		if(!found) {
			System.out.println("Not Found");
		}
	}
	public static void in_sort(int arr[]){
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int curr = arr[i];
            int j = i - 1;
            while (j >= 0 && curr < arr[j]) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = curr;;
        }
    }
	public static void binary(int arr[],int k) {
		int l=0;
		int r=arr.length-1;
		int mid;
		boolean found=false;
		while(l<=r) {
			mid=(l+r)/2;
			if(arr[mid]==k) {
				found=true;
				System.out.println("Found at :"+mid);
				break;
			}
			else if(arr[mid]<k) {
				l=mid+1;
			}
			else {
				r=mid-1;
			}
			
		}
		if(!found) {
			System.out.println("Not Found");
		}
	}
}

/*
 -> Java code is save in .java
 -> Then java compile the code into .class (which is in byte code)
 -> When we do java filename
 		-> java class loader runs and runs the .class file
 		-> Then it is interpreted 
*/