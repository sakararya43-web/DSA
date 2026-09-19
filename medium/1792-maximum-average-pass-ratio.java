class Solution {
    class Pair{
        int val;
        int total;
        Pair(int val,int total)
        {
            this.val=val;
            this.total=total;
        }
        double gain() {
            return (double)(val + 1) / (total + 1)- (double)val / total;
        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.gain(),a.gain()));

        for(int i=0;i<classes.length;i++)
        {             
            pq.add(new Pair(classes[i][0],classes[i][1]));                  
        }

        while(extraStudents > 0)
        {
            Pair temp = pq.poll();
            temp.val++;
            temp.total++;

            pq.add(temp);
            extraStudents--;
        }

        double sum=0;
        while(!pq.isEmpty())
        {   
            Pair temp = pq.poll();
            sum+=(double)temp.val/temp.total;
        }
        return (double) sum/classes.length;
        

        

        

    }
}