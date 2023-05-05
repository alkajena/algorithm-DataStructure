package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSequencing {
	
	
		String jobId;
		int deadLine;
		int profit;
		
		public JobSequencing() {}
		
		public JobSequencing(String jobId, int deadLine, int profit) {
			
			this.jobId = jobId;
			this.deadLine = deadLine;
			this.profit = profit;
		}
		

	
	public class DeadLineComparator implements Comparator<JobSequencing> {
		
		@Override
		public int compare(JobSequencing o1, JobSequencing o2) {
			
			return o2.deadLine - o1.deadLine;
		}
		
	}
	
	public class ProfitComparator implements Comparator<JobSequencing> {
		
		@Override
		public int compare(JobSequencing o1, JobSequencing o2) {
			
			return o2.profit - o1.profit;
		}
		
	}
	public void jobSequencing(List<JobSequencing> jobList, int n) {
		
		Collections.sort(jobList, new DeadLineComparator());
		
		int size = jobList.get(0).deadLine;
		
		Collections.sort(jobList, new ProfitComparator());
		
		String[] result = new String[size];
		
		for(int i = 0; i < jobList.size(); i++) {
			
			int deadLine = jobList.get(i).deadLine;
			
			if(result[deadLine - 1] == null) {
				result[deadLine - 1] = jobList.get(i).jobId;
			}
			else {
				for(int j = deadLine - 2 ; j >= 0; j--) {
					if(result[j] == null) {
						result[j] = jobList.get(i).jobId;
						break;
					}
				}
			}
			
		}
		
		for(int i = 0 ; i < size ; i++) {
			System.out.println("job id : "+result[i]);
		}
		
	}

	public static void main(String[] args) {
		List<JobSequencing> arr = new ArrayList<JobSequencing>();
        arr.add(new JobSequencing("j2", 2, 100));
        arr.add(new JobSequencing("j1", 1, 19));
        arr.add(new JobSequencing("j4", 2, 27));
        arr.add(new JobSequencing("j3", 1, 25));
        arr.add(new JobSequencing("j5", 3, 15));
 
        System.out.println(
            "Following is maximum profit sequence of jobs");
 
      
 
        // Function call
        new JobSequencing().jobSequencing(arr, 0);

	}

	

}
