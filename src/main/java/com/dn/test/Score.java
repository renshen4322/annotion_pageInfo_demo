package com.dn.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:Score
 * Package:com.dn.test
 * Description:
 *
 * @Date:2021/11/20 14:06
 * @Author: mark
 */
@Data
@Builder
public class Score {
    private String studentId;
    private String scoreYear;
    private Double score;

    public Score(){

    }
    public Score(String studentId,String scoreYear,Double score){
        this.studentId= studentId;
        this.scoreYear = scoreYear;
        this.score = score;
    }

}
