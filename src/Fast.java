import java.util.Arrays;

public class Fast {
   public static void main(String[] args)
   {
	   In in = new In(args[0]);
   int N = in.readInt();
   Point[] pointList = new Point[N];
   int index = 0;
   StdDraw.setXscale(0,32768 );
   StdDraw.setYscale(0, 32768);
   StdDraw.show(0);
   StdDraw.setPenRadius(0.01);  // make the points a bit larger
   	   while (!in.isEmpty()) {
	int i = in.readInt();
	int j = in.readInt();
	pointList[index++] = new Point(i, j);
	pointList[index-1].draw();
}
   	   StdDraw.show(0);
   	  
  for (int i = 0; i < N; i++)
  { 
	  Point[] pL2 = new Point[N];
	  for (int j = 0; j < N; j++) {
		pL2[j] = pointList[j];
	}
	 
	  //Arrays.sort(pL2);
	  Arrays.sort(pL2, pointList[i].SLOPE_ORDER);
	  for (int j = 1; j < N-2; j++)
	{ 	int k = j+2;
		while (pointList[i].slopeTo(pL2[j]) == pointList[i].slopeTo(pL2[k]) && k < N-1)
		{	k++;
				
		}
		
		//System.out.println(pointList[i].slopeTo(pL2[j]) +" "+ pointList[i].slopeTo(pL2[k]) );
	if (pointList[i].slopeTo(pL2[j]) == pointList[i].slopeTo(pL2[k-1]) && k - j >2){
		Arrays.sort(pL2, j, --k+1);
	//System.out.println(pointList[i].compareTo(pL2[j]) );
	if (pointList[i].compareTo(pL2[j] )<= 0)
	{System.out.print(pointList[i].toString());
		for (int l = j; l <k+1 ; l++)
	{
			System.out.print("->"+pL2[l].toString());
					
	}
		System.out.print("\n");
	pointList[i].drawTo(pL2[k]);
	
	}
	else j = k;
	}
  }
  }
	 StdDraw.show(0);
}
 
   


}