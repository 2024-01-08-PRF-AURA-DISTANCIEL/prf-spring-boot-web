package fr.maboite.demo.spring.boot.correction.tp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.maboite.demo.spring.boot.correction.tp.controller.CroisiereCorrectionDto;
import fr.maboite.demo.spring.boot.correction.tp.dao.BateauCorrectionDao;
import fr.maboite.demo.spring.boot.correction.tp.dao.CroisiereCorrectionDao;
import fr.maboite.demo.spring.boot.correction.tp.model.BateauCorrection;
import fr.maboite.demo.spring.boot.correction.tp.model.CroisiereCorrection;

@Component
public class CroisiereCorrectionService {

	@Autowired
	private CroisiereCorrectionDao croisiereDao;

	@Autowired
	private BateauCorrectionDao bateauDao;

	/**
	 * Sauvegarde une croisière
	 * 
	 * @param dto
	 * @return
	 */
	public CroisiereCorrectionDto save(CroisiereCorrectionDto dto) {
		// Transformer le DTO en entité
		CroisiereCorrection croisiereCorrection = fromDto(dto);

		if (dto.getBateauId() != null) {
			Optional<BateauCorrection> bateauOptional = bateauDao.findById(dto.getBateauId());
			if (bateauOptional.isPresent()) {
				croisiereCorrection.setBateau(bateauOptional.get());
			}
		}

		// Sauvegarder l'entité
		CroisiereCorrection savedCroisiere = croisiereDao.save(croisiereCorrection);

		// transformer l'entité sauvegardée en DTO pour le retransmettre
		CroisiereCorrectionDto savedDto = toDto(savedCroisiere);
		return savedDto;
	}

	/**
	 * Récupère une croisiere par son identifiant
	 * 
	 * @param id
	 * @return
	 */
	public CroisiereCorrectionDto findById(Long id) {
		Optional<CroisiereCorrection> croisiere = this.croisiereDao.findById(id);
		if (croisiere.isEmpty()) {
			return null;
		}
		// else...
		return toDto(croisiere.get());
	}

	/**
	 * Récupère une croisiere par son port de départ
	 * 
	 * @param id
	 * @return
	 */
	public List<CroisiereCorrectionDto> findByPortDepart(String portDepart) {
		List<CroisiereCorrection> croisieres = this.croisiereDao.findByPortDepart(portDepart);
		return croisieres.stream().map(c -> toDto(c)).collect(Collectors.toList());
		// le code ci-dessus équivaut à :
		// return croisieres.stream().map(this::toDto).collect(Collectors.toList());
		// il équivaut aussi à une boucle qui transforme la collection de Croisiere en
		// une collection de DTOS
	}

	/**
	 * Transforme croisiere en DTO
	 * 
	 * @param croisiere
	 * @return
	 */
	private CroisiereCorrectionDto toDto(CroisiereCorrection croisiere) {
		if (croisiere == null) {
			return null;
		}
		CroisiereCorrectionDto dto = new CroisiereCorrectionDto();
		dto.setId(croisiere.getId());
		dto.setNom(croisiere.getNom());
		dto.setPortDepart(croisiere.getPortDepart());
		dto.setPortArrivee(croisiere.getPortArrivee());
		if (croisiere.getBateau() != null) {
			dto.setBateauId(croisiere.getBateau().getId());
		}
		return dto;
	}

	/**
	 * Transforme un DTO en croisiere
	 * 
	 * @param dto
	 * @return
	 */
	private CroisiereCorrection fromDto(CroisiereCorrectionDto dto) {
		CroisiereCorrection croisiere = new CroisiereCorrection();
		croisiere.setId(dto.getId());
		croisiere.setNom(dto.getNom());
		croisiere.setPortDepart(dto.getPortDepart());
		croisiere.setPortArrivee(dto.getPortArrivee());
		return croisiere;
	}

}
