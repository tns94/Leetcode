package october;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        int counter=0;
        Set<String> hasDNA=new HashSet<>();
        Set<String> processedDNA=new HashSet<>();
        List<String> answer=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if(ch=='A' ||ch=='G' ||ch=='C' ||ch=='T' )
                counter++;
            else
                counter=0;

            if(counter >= 10)
            {
                String temp = s.substring(i - 9, i + 1);
                if (hasDNA.contains(temp)) {
                        answer.add(temp);
                        processedDNA.add(temp);
                        hasDNA.remove(temp);

                }else if(!processedDNA.contains(temp))
                {
                    hasDNA.add(temp);
                }
            }
        }
        return answer;
    }
}
