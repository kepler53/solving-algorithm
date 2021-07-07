package day0707;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_1655_가운데를말해요 {
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = sc.nextInt();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1,o2)-> o1-o2);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)-> o2-o1);
		
		
		for (int i = 0; i < N; i++) {
			
			int number = sc.nextInt();
			// 밸런스 맞춰주기
			if(minHeap.size() == maxHeap.size()) maxHeap.offer(number);
            else minHeap.offer(number);

            if(!minHeap.isEmpty() && !maxHeap.isEmpty()) 
                if(minHeap.peek() < maxHeap.peek()){
                    int tmp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(tmp);
                }
            
            bw.write(maxHeap.peek()+"\n");
		}
		
		bw.flush();
		bw.close();
		
	}

}
