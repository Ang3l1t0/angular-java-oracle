package jpa.seleccion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jpa.seleccion.repository.ProcedimientosRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("criterios")

public class ProcedimientosController {

	@Autowired
	private final ProcedimientosRepository procedimientosRepository;

	public ProcedimientosController(ProcedimientosRepository procedimientosRepository) {
		this.procedimientosRepository = procedimientosRepository;
	}

	private static final String CIUDAD = "CIUDAD";
	private static final String SEXO = "SEXO";
	private static final String DATA_CREDITO = "DATA CREDITO";
	private static final String EDAD = "EDAD";
	private static final String ESTRATO = "ESTRATO";
	private static final String PROFESION = "PROFESION";
	private static final String NIVEL_EDUCATIVO = "NIVEL EDUCATIVO";

	@GetMapping
	/**
	 * Se declaran 5 criterios obligatorios Se declaran las posibles entradas o
	 * values por criterio como opcionales Dependiendo de los criterios que se
	 * escojan entra en el switch case se hace switch case por criterio 5 en total
	 * dependiendo de esos criterios se escogen los values necesarios por cada
	 * criterio como el resto son opcionales no genera error si pasan en blanco
	 */
	
	public String criterios(@RequestParam("criterio1") String criterio1,
			@RequestParam(required = false) Integer porcentaje1, @RequestParam(required = false) String sexo1,
			@RequestParam(required = false) Number pSexo1, @RequestParam(required = false) String sexo2,
			@RequestParam(required = false) Number pSexo2, @RequestParam("criterio2") String criterio2,
			@RequestParam(required = false) Integer porcentaje2, @RequestParam(required = false) String ciudad1,
			@RequestParam(required = false) Number pCiudad1, @RequestParam(required = false) String ciudad2,
			@RequestParam(required = false) Number pCiudad2, @RequestParam(required = false) String ciudad3,
			@RequestParam(required = false) Number pCiudad3, @RequestParam("criterio3") String criterio3,
			@RequestParam(required = false) Integer porcentaje3, @RequestParam(required = false) Number dataCredito1,
			@RequestParam(required = false) Number pDataCredito1, @RequestParam(required = false) Number dataCredito2,
			@RequestParam(required = false) Number pDataCredito2, @RequestParam("criterio4") String criterio4,
			@RequestParam(required = false) Integer porcentaje4, @RequestParam(required = false) Number edad1,
			@RequestParam(required = false) Number edad2, @RequestParam(required = false) Number pRangoEdad1,
			@RequestParam(required = false) Number edad3, @RequestParam(required = false) Number edad4,
			@RequestParam(required = false) Number pRangoEdad2, @RequestParam(required = false) Number edad5,
			@RequestParam(required = false) Number edad6, @RequestParam(required = false) Number pRangoEdad3,
			@RequestParam("criterio5") String criterio5, @RequestParam(required = false) Integer porcentaje5,
			@RequestParam(required = false) Number estrato1, @RequestParam(required = false) Number pEstrato1,
			@RequestParam(required = false) Number estrato2, @RequestParam(required = false) Number pEstrato2,
			@RequestParam(required = false) Number estrato3, @RequestParam(required = false) Number pEstrato3,
			@RequestParam(required = false) Integer porcentaje6, @RequestParam(required = false) String profesion1,
			@RequestParam(required = false) Number pProfesion1, @RequestParam(required = false) String profesion2,
			@RequestParam(required = false) Number pProfesion2, @RequestParam(required = false) String profesion3,
			@RequestParam(required = false) Number pProfesion3, @RequestParam(required = false) Integer porcentaje7,
			@RequestParam(required = false) String nivEdu1, @RequestParam(required = false) Number pNivEdu1,
			@RequestParam(required = false) String nivEdu2, @RequestParam(required = false) Number pNivEdu2,
			@RequestParam(required = false) String nivEdu3, @RequestParam(required = false) Number pNivEdu3) {

		// Validamos la suma de los porcentajes debe ser 100
		
		int total = 0;

		if (porcentaje1 == null) {
			total += 0;
		} else {
			total += porcentaje1;
		}
		if (porcentaje2 == null) {
			total += 0;
		} else {
			total += porcentaje2;
		}
		if (porcentaje3 == null) {
			total += 0;
		} else {
			total += porcentaje3;
		}
		if (porcentaje4 == null) {
			total += 0;
		} else {
			total += porcentaje4;
		}
		if (porcentaje5 == null) {
			total += 0;
		} else {
			total += porcentaje5;
		}
		if (porcentaje6 == null) {
			total += 0;
		} else {
			total += porcentaje6;
		}
		if (porcentaje7 == null) {
			total += 0;
		} else {
			total += porcentaje7;
		}
		
		if (total == 100) {
			
			// hacemos update a la tabla score dejando a todos los candidatos en 0.
			procedimientosRepository.setScoreToZero();

			// validamos los argumentos escogidos para saber que criterios escoger
			switch (criterio1) {
			case SEXO:
				try {
					procedimientosRepository.sexo(porcentaje1, sexo1, pSexo1, sexo2, pSexo2);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case CIUDAD:
				try {
					procedimientosRepository.ciudad(porcentaje2, ciudad1, pCiudad1, ciudad2, pCiudad2, ciudad3,
							pCiudad3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case DATA_CREDITO:
				try {
					procedimientosRepository.dc(porcentaje3, dataCredito1, pDataCredito1, dataCredito2, pDataCredito2);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case EDAD:
				try {
					procedimientosRepository.edad(porcentaje4, edad1, edad2, pRangoEdad1, edad3, edad4, pRangoEdad2,
							edad5, edad6, pRangoEdad3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case ESTRATO:
				try {
					procedimientosRepository.estrato(porcentaje5, estrato1, pEstrato1, estrato2, pEstrato2, estrato3,
							pEstrato3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case PROFESION:
				try {
					procedimientosRepository.profesion(porcentaje6, profesion1, pProfesion1, profesion2, pProfesion2,
							profesion3, pProfesion3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case NIVEL_EDUCATIVO:
				try {
					procedimientosRepository.nivEdu(porcentaje7, nivEdu1, pNivEdu1, nivEdu2, pNivEdu2, nivEdu3,
							pNivEdu3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			}

			switch (criterio2) {
			case SEXO:
				try {
					procedimientosRepository.sexo(porcentaje1, sexo1, pSexo1, sexo2, pSexo2);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case CIUDAD:
				try {
					procedimientosRepository.ciudad(porcentaje2, ciudad1, pCiudad1, ciudad2, pCiudad2, ciudad3,
							pCiudad3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case DATA_CREDITO:
				try {
					procedimientosRepository.dc(porcentaje3, dataCredito1, pDataCredito1, dataCredito2, pDataCredito2);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case EDAD:
				try {
					procedimientosRepository.edad(porcentaje4, edad1, edad2, pRangoEdad1, edad3, edad4, pRangoEdad2,
							edad5, edad6, pRangoEdad3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case ESTRATO:
				try {
					procedimientosRepository.estrato(porcentaje5, estrato1, pEstrato1, estrato2, pEstrato2, estrato3,
							pEstrato3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case PROFESION:
				try {
					procedimientosRepository.profesion(porcentaje6, profesion1, pProfesion1, profesion2, pProfesion2,
							profesion3, pProfesion3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case NIVEL_EDUCATIVO:
				try {
					procedimientosRepository.nivEdu(porcentaje7, nivEdu1, pNivEdu1, nivEdu2, pNivEdu2, nivEdu3,
							pNivEdu3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			}
			switch (criterio3) {
			case SEXO:
				try {
					procedimientosRepository.sexo(porcentaje1, sexo1, pSexo1, sexo2, pSexo2);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case CIUDAD:
				try {
					procedimientosRepository.ciudad(porcentaje2, ciudad1, pCiudad1, ciudad2, pCiudad2, ciudad3,
							pCiudad3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case DATA_CREDITO:
				try {
					procedimientosRepository.dc(porcentaje3, dataCredito1, pDataCredito1, dataCredito2, pDataCredito2);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case EDAD:
				try {
					procedimientosRepository.edad(porcentaje4, edad1, edad2, pRangoEdad1, edad3, edad4, pRangoEdad2,
							edad5, edad6, pRangoEdad3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case ESTRATO:
				try {
					procedimientosRepository.estrato(porcentaje5, estrato1, pEstrato1, estrato2, pEstrato2, estrato3,
							pEstrato3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case PROFESION:
				try {
					procedimientosRepository.profesion(porcentaje6, profesion1, pProfesion1, profesion2, pProfesion2,
							profesion3, pProfesion3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case NIVEL_EDUCATIVO:
				try {
					procedimientosRepository.nivEdu(porcentaje7, nivEdu1, pNivEdu1, nivEdu2, pNivEdu2, nivEdu3,
							pNivEdu3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			}

			switch (criterio4) {
			case SEXO:
				try {
					procedimientosRepository.sexo(porcentaje1, sexo1, pSexo1, sexo2, pSexo2);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case CIUDAD:
				try {
					procedimientosRepository.ciudad(porcentaje2, ciudad1, pCiudad1, ciudad2, pCiudad2, ciudad3,
							pCiudad3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case DATA_CREDITO:
				try {
					procedimientosRepository.dc(porcentaje3, dataCredito1, pDataCredito1, dataCredito2, pDataCredito2);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case EDAD:
				try {
					procedimientosRepository.edad(porcentaje4, edad1, edad2, pRangoEdad1, edad3, edad4, pRangoEdad2,
							edad5, edad6, pRangoEdad3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case ESTRATO:
				try {
					procedimientosRepository.estrato(porcentaje5, estrato1, pEstrato1, estrato2, pEstrato2, estrato3,
							pEstrato3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case PROFESION:
				try {
					procedimientosRepository.profesion(porcentaje6, profesion1, pProfesion1, profesion2, pProfesion2,
							profesion3, pProfesion3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case NIVEL_EDUCATIVO:
				try {
					procedimientosRepository.nivEdu(porcentaje7, nivEdu1, pNivEdu1, nivEdu2, pNivEdu2, nivEdu3,
							pNivEdu3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			}

			switch (criterio5) {
			case SEXO:
				try {
					procedimientosRepository.sexo(porcentaje1, sexo1, pSexo1, sexo2, pSexo2);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case CIUDAD:
				try {
					procedimientosRepository.ciudad(porcentaje2, ciudad1, pCiudad1, ciudad2, pCiudad2, ciudad3,
							pCiudad3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case DATA_CREDITO:
				try {
					procedimientosRepository.dc(porcentaje3, dataCredito1, pDataCredito1, dataCredito2, pDataCredito2);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case EDAD:
				try {
					procedimientosRepository.edad(porcentaje4, edad1, edad2, pRangoEdad1, edad3, edad4, pRangoEdad2,
							edad5, edad6, pRangoEdad3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case ESTRATO:
				try {
					procedimientosRepository.estrato(porcentaje5, estrato1, pEstrato1, estrato2, pEstrato2, estrato3,
							pEstrato3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case PROFESION:
				try {
					procedimientosRepository.profesion(porcentaje6, profesion1, pProfesion1, profesion2, pProfesion2,
							profesion3, pProfesion3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			case NIVEL_EDUCATIVO:
				try {
					procedimientosRepository.nivEdu(porcentaje7, nivEdu1, pNivEdu1, nivEdu2, pNivEdu2, nivEdu3,
							pNivEdu3);
				} catch (NegativeArraySizeException e) {
					// nothing
				}
				break;
			}
			return ("Ok");
		} else {
			System.out.println(total);
			return ("La suma de los porcentajes debe ser 100, no " + total);
		}
	}
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public String handleMissingParams(MissingServletRequestParameterException ex) {
		return ("Debe seleccionar al menos 5 criterios");
	}
}