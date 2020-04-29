package spring.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

import spring.clasesDTO.MascotaDTO;
import spring.clasesDTO.UsuarioDTO;
import spring.model.Administrador;
import spring.model.Dueno;
import spring.model.Usuario;
import spring.model.Veterinario;
import spring.services.TokenService;
//import spring.services.TokenServices;
import spring.services.UsuarioService;
import spring.model.Credentials;


@RestController
@RequestMapping( value = "/usuario", produces =   MediaType.APPLICATION_JSON_VALUE)
public class UsuarioRestController {

	@Autowired
    UsuarioService usuarioService;
    
	@Autowired
    private TokenService tokenService;
    
    private final int EXPIRATION_IN_SEC = 99999999;
	
	@CrossOrigin(origins = "*")
    @PostMapping({"/dueno"})
    public ResponseEntity<?> loginDueno(@RequestBody UsuarioDTO user) {
    	UsuarioDTO userLog = this.usuarioService.loginDuenio(user);
        if ( userLog==null) {
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o password incorrecto");
        }
        String token = tokenService.generateToken(user.getUsername(), EXPIRATION_IN_SEC);
        return ResponseEntity.ok(new Credentials(token, EXPIRATION_IN_SEC, userLog.getUsername(), userLog.getTipo()));
	}
    
    @CrossOrigin(origins = "*")
    @PostMapping({"/administrador"})
    public ResponseEntity<?> loginAdministrador(@RequestBody UsuarioDTO user) {
    	UsuarioDTO userLog = this.usuarioService.loginAdministrador(user);
        if ( userLog==null ) {
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o password incorrecto");
        }
        String token = tokenService.generateToken(user.getUsername(), EXPIRATION_IN_SEC);
        return ResponseEntity.ok(new Credentials(token, EXPIRATION_IN_SEC, userLog.getUsername(), userLog.getTipo()));
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping({"/veterinario"})
    public ResponseEntity<?> loginVeterinario(@RequestBody UsuarioDTO user) {
    	UsuarioDTO userLog = this.usuarioService.loginVeterinario(user);
    	if ( userLog==null ) {
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o password incorrecto");
        }
        String token = tokenService.generateToken(user.getUsername(), EXPIRATION_IN_SEC);
        return ResponseEntity.ok(new Credentials(token, EXPIRATION_IN_SEC, userLog.getUsername(), userLog.getTipo()));
        
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping({"/newVeterinario"})
    public ResponseEntity<UsuarioDTO> createUser(@RequestBody UsuarioDTO user) {
    	UsuarioDTO auxUser = this.usuarioService.createVeterinario(user);
    	if ( auxUser==null ) {
    		return (ResponseEntity<UsuarioDTO>)new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return (ResponseEntity<UsuarioDTO>)new ResponseEntity(auxUser, HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping({"/newDueno"})
    public ResponseEntity<UsuarioDTO> createDueno(@RequestBody UsuarioDTO user) {
    	UsuarioDTO auxUser = this.usuarioService.createDueno(user);
    	if ( auxUser==null ) {
    		return (ResponseEntity<UsuarioDTO>)new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return (ResponseEntity<UsuarioDTO>)new ResponseEntity(auxUser, HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping({"/dataDueno/{username}"})
    public ResponseEntity<UsuarioDTO> dataDueno(@PathVariable("username") final String username) {
    	UsuarioDTO auxUser = this.usuarioService.dataDueno(username);
    	if ( auxUser==null ) {
    		return (ResponseEntity<UsuarioDTO>)new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return (ResponseEntity<UsuarioDTO>)new ResponseEntity(auxUser, HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping({"/dataVeterinario/{username}"})
    public ResponseEntity<UsuarioDTO> dataVeterinario(@PathVariable("username") final String username) {
    	UsuarioDTO auxUser = this.usuarioService.dataVeterinario(username);
    	if ( auxUser==null ) {
    		return (ResponseEntity<UsuarioDTO>)new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return (ResponseEntity<UsuarioDTO>)new ResponseEntity(auxUser, HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping({"/updateDueno"})
    public ResponseEntity<UsuarioDTO> updateDueno(@RequestBody UsuarioDTO user) {
    	UsuarioDTO auxUser = this.usuarioService.updateDueno(user);
    	if ( auxUser==null ) {
    		return (ResponseEntity<UsuarioDTO>)new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return (ResponseEntity<UsuarioDTO>)new ResponseEntity(auxUser, HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping({"/updateVeterinario"})
    public ResponseEntity<UsuarioDTO> updateVeterinario(@RequestBody UsuarioDTO user) {
    	UsuarioDTO auxUser = this.usuarioService.updateVeterinario(user);
    	if ( auxUser==null ) {
    		return (ResponseEntity<UsuarioDTO>)new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return (ResponseEntity<UsuarioDTO>)new ResponseEntity(auxUser, HttpStatus.OK);

    }
 
    @CrossOrigin(origins = "*")
    @GetMapping({"/allVeterinarios"})
    public ResponseEntity<List<UsuarioDTO>> allVeterinarios() {
    	final List<UsuarioDTO> vets = this.usuarioService.allVeterinarios();
    	if ( vets==null ) {
    		return (ResponseEntity<List<UsuarioDTO>>)new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return (ResponseEntity<List<UsuarioDTO>>)new ResponseEntity(vets, HttpStatus.OK);
    }
}
