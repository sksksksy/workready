package site.tj.program.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.tj.program.mapper.WorkProgramTjMapper;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class WPTJService {
    @Autowired(required = false)
    WorkProgramTjMapper wptj;
    public double EveryMoney(String EmplNo,String ProgNo){
        /*double grts=getEmplOneWordDay(EmplNo,ProgNo);
        double grzjj=getMoneyByEmplInProg(EmplNo,ProgNo);
        double xmzts=getDaysInProg(ProgNo);
        double xmzjj=getNoteMoney(ProgNo);
        double xmzje=getMoneyByProg(ProgNo);
        BigDecimal grgz=AverageSalary(grts,grzjj,xmzts,xmzjj,xmzje);*/
        Map<String,Double> r=progData(EmplNo,ProgNo);
        return r.get("grgz");
    }
    public Map<String,Double> progData(String EmplNo,String ProgNo){
        Map<String,Double> df=new HashMap<String,Double>();
        double grts=getEmplOneWordDay(EmplNo,ProgNo);
        double grzjj=getMoneyByEmplInProg(EmplNo,ProgNo);
        double xmzts=getDaysInProg(ProgNo);
        double xmzjj=getNoteMoney(ProgNo);
        double xmzje=getMoneyByProg(ProgNo);
        df.put("grts",grts);//个人天数
        df.put("grzjj",grzjj);//个人项目总奖金
        df.put("xmzts",xmzts);//项目总天数
        df.put("xmzjj",xmzjj);//项目总奖金
        df.put("xmzje",xmzje);//项目总金额
        BigDecimal grgz=AverageSalary(grts,grzjj,xmzts,xmzjj,xmzje);
        df.put("grgz",grgz.doubleValue());//个人工资
        return df;
    }
    public double getEmplOneWordDay(String EmplNo,String ProgNo){
        double d=wptj.getEmplOneWordDay(EmplNo, ProgNo);
        double r=d<0?0:d;
        return r;
    }
    public double getMoneyByEmplInProg(String EmplNo,String ProgNo){
        double d=wptj.getMoneyByEmplInProg(EmplNo, ProgNo);
        double r=d<0?0:d;
        return r;
    }
    public double getDaysInProg(String ProgNo){
        double d=wptj.getDaysInProg(ProgNo);
        double r=d<0?0:d;
        return r;
    }
    public double getNoteMoney(String ProgNo){
        double d=wptj.getNoteMoney(ProgNo);
        double r=d<0?0:d;
        return r;
    }
    public double getMoneyByProg(String ProgNo){
        double d=wptj.getMoneyByProg(ProgNo);
        double r=d<0?0:d;
        return r;
    }

    /**
     *
     * @param grts 个人天数
     * @param grzjj 个人总奖金
     * @param xmzts 项目总天数
     * @param xmzjj 项目总奖金
     * @param xmzje 项目总金额
     * @return
     */
    public BigDecimal AverageSalary(double grts,double grzjj,double xmzts,double xmzjj,double xmzje){
        BigDecimal bgrts=new BigDecimal(grts);
        BigDecimal bgrzjj=new BigDecimal(grzjj);
        BigDecimal bxmzts=new BigDecimal(xmzts);
        BigDecimal bxmzjj=new BigDecimal(xmzjj);
        BigDecimal bxmzje=new BigDecimal(xmzje);
        BigDecimal mrmtje=bxmzje.subtract(bxmzjj).divide(bxmzts);
        BigDecimal grgz=mrmtje.multiply(bgrts).add(bgrzjj);
        return grgz;
    }
}
