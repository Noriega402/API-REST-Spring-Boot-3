/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.direccion.DatosDireccion;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *
 * @author Daniel Noriega
 */
@RestController
@RequestMapping("/medicos")
public class MedicoController {

    // NOTA: no es recomendable usar Autowired para pruebas unitarias
    @Autowired
    private MedicoRepository medicoRepository;
    
    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico){
        //System.out.println("El request llego de manera correcta");
        //System.out.println(datosRegistroMedico);
        medicoRepository.save(new Medico(datosRegistroMedico));
    }

    // mostar listado sin paginacion
    //@GetMapping
    // public List<DatosListadoMedico> listadoMedicos(){
    //     return medicoRepository.findAll().stream().map(DatosListadoMedico::new).toList();
    // }

    //Mostrar listado con paginacion
    @GetMapping
    public Page<DatosListadoMedico> listadoMedicos(@PageableDefault(size = 2) Pageable paginacion){
        //return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        return medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new);
    }

    //@PageableDefault(size = 2) dar un valor por defecto de cuantos items se muestran por paginacion

    @PutMapping
    @Transactional
    public ResponseEntity actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico) {
        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
        return ResponseEntity.ok(new DatosRespuestaMedico(
                medico.getId(), medico.getNombre(), medico.getEmail(), medico.getTelefono(),
                medico.getEspecialidad().toString(),
                new DatosDireccion(medico.getDireccion().getDistrito(),
                        medico.getDireccion().getCalle(), medico.getDireccion().getDistrito(),
                        medico.getDireccion().getNumero(), medico.getDireccion().getCiudad())));
    }

//    @DeleteMapping("/{id}")
//    @Transactional
//    public void eliminarMedico(@PathVariable Long id){
//        Medico medico = medicoRepository.getReferenceById(id);
//        medicoRepository.delete(medico);
//    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedico(@PathVariable Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
        return ResponseEntity.noContent().build();
    }
}
