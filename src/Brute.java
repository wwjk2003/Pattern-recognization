import java.util.Arrays;




public class Brute {
	
		   
		
	
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
       	   Arrays.sort(pointList);
	   for (int i = 0; i < pointList.length; i++) {
		   for (int j = i+1; j < pointList.length; j++) {
			   for (int j2 = j+1; j2 < pointList.length; j2++) {
				for (int k = j2+1; k < pointList.length; k++) {
					
					if (pointList[i].slopeTo(pointList[j]) == pointList[j].slopeTo(pointList[j2]) && pointList[j].slopeTo(pointList[j2]) == pointList[j2].slopeTo(pointList[k])) {
						System.out.println(pointList[i].toString()+"->"+pointList[j].toString()+"->"+pointList[j2].toString()+"->"+pointList[k].toString());
						pointList[i].drawTo(pointList[k]);
					}
//					else {
//						 return false;
//					}
				}
			}
			
		}
		
	}
	   StdDraw.show(0);
	   
   }
   
}