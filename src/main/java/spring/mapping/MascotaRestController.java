package spring.mapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import spring.clasesDTO.MascotaDTO;
import spring.model.Mascota;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import spring.services.MascotaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/mascota", produces =   MediaType.APPLICATION_JSON_VALUE)
public class MascotaRestController {
    @Autowired
    MascotaService mascotaService;

    /*
    @CrossOrigin(origins = "*")
    @GetMapping({ "/{id}" })
    public ResponseEntity<List<MascotaDTO>> listAllMascotasById(@PathVariable("id") final int id) {
    	final List<MascotaDTO> mascotas = this.mascotaService.findAllMascotasDeDueno(id);
    	if (mascotas==null) {
    		return (ResponseEntity<List<MascotaDTO>>)new ResponseEntity(HttpStatus.NO_CONTENT);
    	}
        return (ResponseEntity<List<MascotaDTO>>)new ResponseEntity((Object)mascotas, HttpStatus.OK);
    }
    */
    
    @CrossOrigin(origins = "*")
    @GetMapping({ "/{username}" })
    public ResponseEntity<List<MascotaDTO>> listAllMascotasByUsername(@PathVariable("username") final String username) {
    	final List<MascotaDTO> mascotas = this.mascotaService.findAllMascotasDeDuenoByUsername(username);
    	if (mascotas==null) {
    		return (ResponseEntity<List<MascotaDTO>>)new ResponseEntity(HttpStatus.NO_CONTENT);
    	}
        return (ResponseEntity<List<MascotaDTO>>)new ResponseEntity((Object)mascotas, HttpStatus.OK);
    }
    	
    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<MascotaDTO> addMascotas(@RequestBody final MascotaDTO mascota) {
	       final MascotaDTO mascotaAux = this.mascotaService.addMascota(mascota);
	       if (mascotaAux == null) {
	    	   return (ResponseEntity<MascotaDTO>)new ResponseEntity(HttpStatus.NO_CONTENT);
	        }
	        return (ResponseEntity<MascotaDTO>)new ResponseEntity((Object)mascotaAux, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<MascotaDTO>> listAll() {
    	final List<MascotaDTO> mascotas = this.mascotaService.listAll();
        if (mascotas==null) {
            return (ResponseEntity<List<MascotaDTO>>)new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return (ResponseEntity<List<MascotaDTO>>)new ResponseEntity((Object)mascotas, HttpStatus.OK);
    }
}