/**
*查询出某个人员所参与的项目
**/
select d.*,p.* from day_records d,work_programs p where d.PROG_NO=p.PROG_NO and d.PROG_NO <>''; -- or
select d.*,p.* from day_records d  cross join work_programs p on d.PROG_NO=p.PROG_NO where d.PROG_NO <>'';
/**
*查询出某个曾经完成的项目并获取了多少钱
**/
select * from emplyees_record er where er.EMPL_NO=?;
/**
*如何计算某个人在某个项目里面应该得多少钱,(平均分配原则)
**/
select sum(d.DAYS) as e_days from day_records d where d.EMPL_NO=? and d.PROG_NO=?;-- 获取上班的天数

select sum(d.NOTE_PAY) as e_npay from day_records d where d.EMPL_NO=? and d.PROG_NO=? ; -- 获取上班每天额外获得的金额

select sum(d.DAYS) as a_days from day_records d where d.PROG_NO=?; -- 获取该项目总的上班天数，每个人的上班天数之和

select sum(d.NOTE_PAY) as a_npay from day_records d where d.PROG_NO=? ; -- 获取中的奖励金额之和

select (p.PROG_PAY+p.PROG_ADD_PAY) as a_pay from work_programs p where p.PROG_NO='prog_20200723#9'; -- 获取项目的总金额

/***
*	平均原则下：
		每个人获得金额的公式为: ((项目的总金额-所有奖励金额)/项目所有人的工作天数之和)*工作天数+项目奖励金额
			((a_pay-a_npay)/a_days)*e_days+e_npay
    非平均原则:
		死工资+奖金原则:
			
        项目系数原则:
			emplyees_recordday_recordsday_recordsemplyees
*
**/