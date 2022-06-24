Below is an in-place algorithm to reverse an array of integers

reverseArray(int []arr, int n)
[]arr = {1, 2, 3, 4, 5, 6}
int n = 6
[]arr = a[0, 1, 2, 3, 4, 5]

for (int i = 0; i < n / 2; i++)
            arr[i] = __(arr[n - i - 1], arr[n - i - 1] = arr[i]);
{
	//i = 0; i < 3; i++
		arr[0] = __(arr[5], arr[5] = arr[0]);
				{
					return arr[5];
				}
	//i = 1; i < 3; i++
		arr[0] = __(arr[4], arr[4] = arr[1]);
				{
					return arr[4]
				}
	//i = 2; i < 3; i++
		arr[0] = __(arr[3], arr[3] = arr[2]);
				{
					return arr[3] 
				}

}