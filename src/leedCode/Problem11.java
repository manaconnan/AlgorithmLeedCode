package leedCode;

public class Problem11 {
    public static void main(String[] args) {
        Problem11 p = new Problem11();
        String s = "hello";
        System.out.println((int)s.charAt(1));
      // int[] height = {2,3,10,5,7,8,9}; // expect 35
        //System.out.println(p.maxArea(height));
    }
    public int maxArea(int[] height) {
        int m = 0;
        int i = m;
        int n = height.length-1;
        int j = n;
        int temArea = area(height,m,n);
        while(i<j){
            while(height[i]<=height[m]&&i<j){
                i++;
            }

            if(i<j){
                m=i;
                n=j;
                temArea = max(temArea,area(height,m,n));
            }
            while(height[j]<=height[n]&&i<j){
                j--;
            }
            if(i<j){
                m=i;
                n=j;
                temArea = max(temArea,area(height,m,n));
            }
        }
        return temArea;

    }
    private int area(int[] height,int left,int right){
        return (right-left)*min(height[left],height[right]);
    }
    private int min(int a,int b){
        return a>=b?b:a;
    }
    private int max(int a,int b){
        return a>=b?a:b;
    }
}
