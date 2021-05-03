-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- CONSIGNACION
CREATE OR REPLACE PROCEDURE consignacion (cuenta IN NUMBER, valor IN NUMBER) AS 
BEGIN 
	UPDATE CUENTA SET CUENTA_MONTO = (CUENTA_MONTO + valor) WHERE CUENTA_NUMERO = cuenta;
	INSERT INTO TRANSACCIONES (CUENTA_ID, T_TIPO, T_CANTIDAD, T_FECHA) VALUES ((SELECT CUENTA_ID FROM CUENTA WHERE CUENTA_NUMERO = cuenta), 'CONSIGNACION', valor, (SELECT CURRENT_TIMESTAMP from dual));
END;

CALL CONSIGNACION(88819900929, 2000000);
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- RETIRO
CREATE OR REPLACE PROCEDURE retiro (cuenta IN NUMBER, valor IN NUMBER) IS
	maximo NUMBER;
BEGIN
	SELECT cuenta_monto INTO maximo FROM CUENTA WHERE CUENTA_NUMERO = cuenta;
	IF maximo >= valor THEN
		UPDATE CUENTA SET CUENTA_MONTO = (CUENTA_MONTO - valor) WHERE CUENTA_NUMERO = cuenta;
		INSERT INTO TRANSACCIONES (CUENTA_ID, T_TIPO, T_CANTIDAD, T_FECHA) VALUES ((SELECT CUENTA_ID FROM CUENTA WHERE CUENTA_NUMERO = cuenta), 'RETIRO', valor, (SELECT CURRENT_TIMESTAMP from dual));
	ELSE
		dbms_output.put_line('SALDO INSUFICIENTE');
	END IF;
END;

CALL RETIRO(88819900929, 2000000);
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- CONSULTA
CREATE OR REPLACE PROCEDURE consulta (cuenta IN NUMBER) AS
	con NUMBER;
BEGIN
	SELECT cuenta_monto INTO con FROM CUENTA WHERE CUENTA_NUMERO = cuenta;
	INSERT INTO TRANSACCIONES (CUENTA_ID, T_TIPO, T_CANTIDAD, T_FECHA) VALUES ((SELECT CUENTA_ID FROM CUENTA WHERE CUENTA_NUMERO = cuenta), 'CONSULTA', 0, (SELECT CURRENT_TIMESTAMP from dual));
	dbms_output.put_line(CON);
END;

CALL CONSULTA (88819900929);
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Consulta INTERES MANUAL
CREATE OR REPLACE PROCEDURE interes (cuenta IN NUMBER) AS
BEGIN
	UPDATE CUENTA SET cuenta_monto = CUENTA_MONTO * (1 + (
		SELECT PROD_INTERES FROM PRODUCTO WHERE PROD_ID = (
			SELECT PROD_ID FROM CUENTA WHERE CUENTA_NUMERO=cuenta)));
	INSERT INTO TRANSACCIONES (CUENTA_ID, T_TIPO, T_CANTIDAD, T_FECHA) VALUES ((SELECT CUENTA_ID FROM CUENTA WHERE CUENTA_NUMERO = cuenta), 'CONSULTA INTERES', 0, (SELECT CURRENT_TIMESTAMP from dual));
END;

CALL INTERES(88819900929);
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- INTERES AUTOMATIO 00:00 H
BEGIN 
	DBMS_SCHEDULER.CREATE_JOB (
		job_name		=>	'INTERES_DIARIO',
		job_type		=>	'STORED_PROCEDURE',
		job_action		=>	'INTERES_AUTOMATICO',
		start_date		=>	'10-FEB-21 4.25.00 PM',
		repeat_interval	=>	'FREQ=DAILY;',
		end_date		=>	'20-FEB-21 4.25.00 PM',
		auto_drop		=>	FALSE,
		comments		=>	'calculo de interes automatico');
END;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- INTERES DIARIO QUE USA EL JOB
CREATE OR REPLACE PROCEDURE TS_USER_01.interes_automatico AS 
	CURSOR registros IS 
		SELECT * FROM CUENTA;
	
BEGIN
	FOR fila IN registros
	LOOP
		UPDATE CUENTA SET cuenta_monto = CUENTA_MONTO * (1 + (
			SELECT PROD_INTERES FROM PRODUCTO WHERE PROD_ID = (
				SELECT PROD_ID FROM CUENTA WHERE CUENTA_NUMERO=fila.CUENTA_NUMERO)));
		INSERT INTO TRANSACCIONES (CUENTA_ID, T_TIPO, T_CANTIDAD, T_FECHA) 
			VALUES ((SELECT CUENTA_ID FROM CUENTA WHERE CUENTA_NUMERO = FILA.cuenta_numero), 'CONSIGNACION AUTOMATICA DE INTERES', 0, (SELECT CURRENT_TIMESTAMP from dual));
	END LOOP;
END;

	

