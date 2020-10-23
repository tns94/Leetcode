package october;
/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3483/
 */

import java.util.Arrays;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
    Arrays.sort(intervals,(o1, o2) -> o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0]);
        int counter=0;
        int i=0,j=1;
        while (j < intervals.length)
        {
            if(i==j)
            {
                j++;
                continue;
            }
            int a=intervals[i][0];
            int b=intervals[i][1];
            int c=intervals[j][0];
            int d=intervals[j][1];

            if(a <= c && b >= d )
                counter++;
            else
                i=j;
            j++;
        }
        return intervals.length-counter;
    }

    public static void main(String[] args) {
        RemoveCoveredIntervals removeCoveredIntervals=new RemoveCoveredIntervals();
        System.out.println(removeCoveredIntervals.removeCoveredIntervals(new int[][]{{13109,30355},{14355,75231},{6921,63510},{10753,60339},{30260,90631},{39416,62329},{98027,98421},{5620,61041},{42853,58054},{14910,69902},{55367,56112},{17322,91252},{40539,56808},{33111,80423},{67135,79310},{54866,99547},{35068,74772},{22842,57829},{9602,39310},{35679,64090},{30952,43709},{19346,65138},{63370,95142},{4543,40460},{23293,36079},{23267,38870},{39683,99428},{60277,64267},{45953,54533},{38891,54482},{22193,97712},{39601,78713},{1602,18834},{40423,61677},{37031,38280},{67759,98501},{31822,69166},{81644,91218},{40997,49654},{50432,79245},{15999,74502},{12258,94310},{1200,34571},{62564,85579},{8925,48317},{58351,91054},{26258,83577},{1082,48635},{52807,85615},{61353,84126},{74860,88736},{33859,86464},{44590,46261},{96065,99021},{52060,71520},{31863,75782},{36527,57650},{45393,66528},{53602,58122},{4643,91953},{26651,74472},{16474,93468},{8811,89971},{21284,47759},{77981,97456},{7538,94376},{24285,44250},{31225,41530},{3727,6833},{24801,38172},{6963,83306},{15014,39650},{38327,90573},{13511,25344},{22342,68867},{44709,78775},{17163,31168},{32131,86047},{16484,51734},{22148,38856},{64157,67119},{24233,27862},{26272,46847},{13496,95622},{12564,65656},{6989,22523},{3165,49034},{39105,93580},{32468,98078},{59086,67200},{49148,49330},{16724,60391},{39355,58395},{74519,86984},{18790,76134},{9080,38945},{39703,68492},{60560,65602},{30704,62849},{46295,57818},{84728,90238},{64969,84699},{84605,97762},{7133,85615},{73343,84268},{19938,28878},{5120,19948},{58177,72667},{88204,92601},{2016,78868},{77259,89747},{27474,97660},{24068,70174},{27721,43646},{1389,24883},{96445,96501},{37671,80264},{12990,41781},{9934,99242},{6479,88310},{54070,73098},{23849,38766},{33655,61753},{26040,81566},{43823,88651},{20345,66441},{51867,80063},{39659,69950},{12506,20823},{54669,84902},{37582,52938},{130,45052},{99372,99864},{8273,17303},{25155,25883},{10570,49462},{16021,91376},{18897,33590},{37063,42105},{36591,80022},{70453,98618},{19118,42704},{28159,32421},{58054,93673},{43495,53983},{29566,53273},{40727,66994},{25899,89747},{4496,39965},{17341,18539},{14464,32753},{85612,87913},{85139,99840},{62339,70895},{2726,61059},{12798,73410},{37202,52222},{48226,68581},{7319,77121},{6331,81895},{544,52558},{11678,86131},{5543,29218},{26604,46492},{55661,70393},{36959,91314},{27431,28930},{48215,60769},{70702,89800},{76498,84448},{1192,4602},{20422,76399},{21212,23548},{18783,90754},{12185,43591},{94796,98234},{41858,78230},{33205,45185},{66817,82055},{8786,50927},{18136,56541},{2743,68227},{86790,94288},{73471,75914},{33741,39740},{8201,51109},{28469,32852},{18177,27585},{23307,89582},{48591,49356},{3717,61839},{6907,43862},{5366,54255},{29732,89764},{19921,65350},{35226,52579},{16199,85268},{61361,82851},{61723,97523},{10086,35964}}));
    }
}
