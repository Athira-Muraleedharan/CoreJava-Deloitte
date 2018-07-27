
public class UserMainCode {
	public static boolean checkTripplets(int arr[]) {
		if(arr.length<3)
			return false;
		else {
			for(int i=2;i<arr.length;i++) {
				if(arr[i]==arr[i-1] && arr[i-1]==arr[i-2])
					return true;
			}
			return false;
}

}
}
