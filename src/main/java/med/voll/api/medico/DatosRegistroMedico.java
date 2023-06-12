/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.direccion.DatosDireccion;

/**
 *
 * @author Daniel Noriega
 *
 */
public record DatosRegistroMedico(@NotBlank String nombre,
                                  @NotBlank //es lo mismo que un not null
                                  @Email // valida que sea un email
                                  String email,
                                  @NotBlank
                                  String telefono,
                                  @NotBlank
                                  @Pattern(regexp = "\\d{4,6}") //expresion regular para que tenga de 4 a 6 caracteres
                                  String documento,
                                  @NotNull
                                  Especialidad especialidad,
                                  @NotNull
                                  @Valid
                                  DatosDireccion direccion) {

}
