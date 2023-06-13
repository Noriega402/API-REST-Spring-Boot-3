/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direccion;

/**
 *
 * @author Daniel Noriega
 */
@Table(name = "medicos") //nombrando la tabla
@Entity(name = "Medico") // nombre de la Entidad
@Getter // Generar los getters automaticamente
@NoArgsConstructor // generar contructor automaticamente
@EqualsAndHashCode(of = "id")
public class Medico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @Embedded
    private Direccion direccion;
    
    public Medico(DatosRegistroMedico datosRegistroMedico){
        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.documento = datosRegistroMedico.documento();
        this.telefono = datosRegistroMedico.telefono();
        this.especialidad = datosRegistroMedico.especialidad();
        this.direccion = new Direccion(datosRegistroMedico.direccion());
    }

    public void actualizarDatos(DatosActualizarMedico datosActualizarMedico) {
        if(datosActualizarMedico.nombre() != null){
            this.nombre = datosActualizarMedico.nombre();
        }
        if(datosActualizarMedico.documento() != null){
            this.documento = datosActualizarMedico.documento();
        }
        if(datosActualizarMedico.direccion() != null){
            this.direccion = direccion.actualizarDatos(datosActualizarMedico.direccion());
        }
    }
}
