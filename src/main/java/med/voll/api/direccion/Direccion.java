/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author Daniel Noriega
 */
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {
    
    private String calle;
    private String numero;
    private String ciudad;
    private String distrito;
    private String complemento;

    public Direccion(DatosDireccion direccion) {
        this.calle = direccion.calle();
        this.numero = direccion.numero();
        this.ciudad = direccion.ciudad();
        this.distrito = direccion.distrito();
        this.complemento = direccion.complemento();
    }
    
}
