package jpa.seleccion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jpa.seleccion.model.Candidatos;

public interface ProcedimientosRepository extends JpaRepository<Candidatos, Long> {

        // Procedimiento sexo
        @Query(value = "{call sexo(:porcentaje, :sexo1, :pSexo1, :sexo2, :pSexo2)}", nativeQuery = true)
        void sexo(@Param("porcentaje") Number porcentaje, @Param("sexo1") String sexo1, @Param("pSexo1") Number pSexo1,
                        @Param("sexo2") String sexo2, @Param("pSexo2") Number pSexo2);

        // Procedimiento ciudad
        @Query(value = "{call ciudad(:porcentaje, :ciudad1, :pCiudad1, :ciudad2, :pCiudad2, :ciudad3, :pCiudad3)}", nativeQuery = true)
        void ciudad(@Param("porcentaje") Number porcentaje, @Param("ciudad1") String ciudad1,
                        @Param("pCiudad1") Number pCiudad1, @Param("ciudad2") String ciudad2,
                        @Param("pCiudad2") Number pCiudad2, @Param("ciudad3") String ciudad3,
                        @Param("pCiudad3") Number pCiudad3);

        // Procedimiento data credito
        @Query(value = "{call dc(:porcentaje, :dataCredito1, :pDataCredito1, :dataCredito2, :pDataCredito2)}", nativeQuery = true)
        void dc(@Param("porcentaje") Number porcentaje, @Param("dataCredito1") Number dataCredito1,
                        @Param("pDataCredito1") Number pDataCredito1, @Param("dataCredito2") Number dataCredito2,
                        @Param("pDataCredito2") Number pDataCredito2);

        // Procedimiento edad
        @Query(value = "{call edad(:porcentaje, :edad1, :edad2, :pRangoEdad1, :edad3, :edad4, :pRangoEdad2, :edad5, :edad6, :pRangoEdad3)}", nativeQuery = true)
        void edad(@Param("porcentaje") Number porcentaje, @Param("edad1") Number edad1, @Param("edad2") Number edad2,
                        @Param("pRangoEdad1") Number pRangoEdad1, @Param("edad3") Number edad3,
                        @Param("edad4") Number edad4, @Param("pRangoEdad2") Number pRangoEdad2,
                        @Param("edad5") Number edad5, @Param("edad6") Number edad6,
                        @Param("pRangoEdad3") Number pRangoEdad3);

        // Procedimiento estrato
        @Query(value = "{call estrato(:porcentaje, :estrato1, :pEstrato1, :estrato2, :pEstrato2, :estrato3, :pEstrato3)}", nativeQuery = true)
        void estrato(@Param("porcentaje") Number porcentaje, @Param("estrato1") Number estrato1,
                        @Param("pEstrato1") Number pEstrato1, @Param("estrato2") Number estrato2,
                        @Param("pEstrato2") Number pEstrato2, @Param("estrato3") Number estrato3,
                        @Param("pEstrato3") Number pEstrato3);

        // Procedimiento profesion
        @Query(value = "{call profesion(:porcentaje, :profesion1, :pProfesion1, :profesion2, :pProfesion2, :profesion3, :pProfesion3)}", nativeQuery = true)
        void profesion(@Param("porcentaje") Number porcentaje, @Param("profesion1") String profesion1,
                        @Param("pProfesion1") Number pProfesion1, @Param("profesion2") String profesion2,
                        @Param("pProfesion2") Number pProfesion2, @Param("profesion3") String profesion3,
                        @Param("pProfesion3") Number pProfesion3);

        // Procedimiento nivel educativo
        @Query(value = "{call niv_edu(:porcentaje, :nivEdu1, :pNivEdu1, :nivEdu2, :pNivEdu2, :nivEdu3, :pNivEdu3)}", nativeQuery = true)
        void nivEdu(@Param("porcentaje") Number porcentaje, @Param("nivEdu1") String nivEdu1,
                        @Param("pNivEdu1") Number pNivEdu1, @Param("nivEdu2") String nivEdu2,
                        @Param("pNivEdu2") Number pNivEdu2, @Param("nivEdu3") String nivEdu3,
                        @Param("pNivEdu3") Number pNivEdu3);

        @Transactional
        @Modifying
        @Query(value = "UPDATE SCORES SET score = 0", nativeQuery = true)
        void setScoreToZero();
}
