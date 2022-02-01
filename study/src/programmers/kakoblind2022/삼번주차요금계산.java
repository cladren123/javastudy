package programmers.kakoblind2022;

import java.util.*;

public class 삼번주차요금계산 {



    public static void main(String[] args) {

        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        System.out.println(Arrays.toString(solution(fees, records)));

    }

    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        HashMap<String, Integer> store = new HashMap<>();
        HashMap<String, Integer> parkTime = new HashMap<>();

        for(String record : records)
        {
            String[] one = record.split(" ");

            String[] recordTime = one[0].split(":");

            int time = Integer.valueOf(recordTime[0]) * 60 + Integer.valueOf(recordTime[1]);

            String carNumber = one[1];
            String inOut = one[2];

            if(inOut.equals("IN"))
            {
                store.put(carNumber, time);
            }
            else if(inOut.equals("OUT"))
            {
                int allTime = time - store.remove(carNumber);
                parkTime.put(carNumber, parkTime.getOrDefault(carNumber, 0) + allTime);
            }
        }

        System.out.println(store);



        for(String carNumber : store.keySet())
        {
            // 왜 여기에 remove를 사용하면 런타임에러가 뜨는 것이지?
            // for문을 돌고 있는 와중에 remove를 해서 런타임 에러가 발생하는거 같다.
            int startTime = store.get(carNumber);
            int allTime = (23 * 60 + 59) - startTime;
            parkTime.put(carNumber, parkTime.getOrDefault(carNumber, 0) + allTime);
        }

        // System.out.println(store);
        // System.out.println(parkTime);

        ArrayList<String> cars = new ArrayList<>();

        for(String car : parkTime.keySet())
            cars.add(car);

        Collections.sort(cars);

        // System.out.println(cars);

        answer = new int[cars.size()];

        int gibonTime = fees[0];
        int gibonFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        for(int i = 0; i < cars.size(); i++)
        {
            int time = parkTime.get(cars.get(i));
            time -= gibonTime;

            if(time <= 0) answer[i] = gibonFee;
            else if(time > 0)
            {
                int unit = time / unitTime;
                if(time % unitTime != 0) unit += 1;

                answer[i] = gibonFee + (unit * unitFee);
            }
        }





        return answer;
    }

}
