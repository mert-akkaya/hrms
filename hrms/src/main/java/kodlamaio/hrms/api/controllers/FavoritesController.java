package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.FavoriteService;
import kodlamaio.hrms.entities.concretes.Favorite;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin
public class FavoritesController {

	private FavoriteService favoriteService;
	
	@Autowired
	public FavoritesController(FavoriteService favoriteService) {
		this.favoriteService= favoriteService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		var result = this.favoriteService.getAll();
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getByCandidateAndJobAdvertisementId")
	public ResponseEntity<?> findByCandidateIdAndJobAdvertisementId(@RequestParam int candidateId,int jobAdvertismentId){
		var result = this.favoriteService.findByCandidateIdAndJobAdvertisementId(candidateId, jobAdvertismentId);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	
	@GetMapping("/getByCandidateId")
	public ResponseEntity<?> getByCandidateId(@RequestParam int id){
		var result = this.favoriteService.getByCandidateId(id);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Favorite favorite){
		var result = this.favoriteService.add(favorite);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int favoriteId){
		var result = this.favoriteService.remove(favoriteId);
		if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
	}
}
