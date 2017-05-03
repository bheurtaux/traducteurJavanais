package integration;

import java.util.ArrayList;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ressources.RSLien;
import ressources.RSMenu;
import services.IServiceTraduction;

@RestController
public class Controller {
	
	@Autowired
	IServiceTraduction serviceTraduction;
    
    @RequestMapping("/")
    public RSMenu welcome() {
    	final RSMenu main = new RSMenu();
    	main.setMessage("Bienvenue sur le traducteur de Javanais");
    	main.setLiens(new ArrayList<RSLien>());
    	main.getLiens().add(new RSLien("/encode?text=mon Texte"));
    	main.getLiens().add(new RSLien("/decode?text=mavon Tavextave"));
        return main;
    }
    
    @RequestMapping("/encode")
    public String encode(@PathParam("id") String text) {
        return text+" => "+serviceTraduction.encode(text);
    }
    
    @RequestMapping("/decode")
    public String decode(@PathParam("id") String text) {
        return text+" => "+serviceTraduction.decode(text);
    }
    
}
