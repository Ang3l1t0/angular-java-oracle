BEGIN
  SYS.DBMS_SCHEDULER.CREATE_JOB
    (
       job_name        => 'TS_USER_01.CONSULTA_INTERES2'
      ,start_date      => systimestamp
      ,repeat_interval => 'FREQ=MINUTELY;INTERVAL=2'
      ,end_date        => NULL
      ,job_class       => 'DEFAULT_JOB_CLASS'
      ,job_type        => 'STORED_PROCEDURE'
      ,job_action      => 'INTERES'
,comments        => 'INTERES GANDO');
  SYS.DBMS_SCHEDULER.ENABLE
    (name                  => 'TS_USER_01.CONSULTA_INTERES2');
end;

