/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.direccion;

import jakarta.persistence.Embeddable;

/**
 *
 * @author Daniel Noriega
 */
@Embeddable
public class Direccion {
    
    private String calle;
    private Long numero;
    private String ciudad;
    private String distrito;
    private String complemento;
    
}
