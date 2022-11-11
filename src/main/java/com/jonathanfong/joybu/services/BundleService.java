package com.jonathanfong.joybu.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathanfong.joybu.models.Bundle;
import com.jonathanfong.joybu.repositories.BundleRepository;

@Service	
public class BundleService {
		@Autowired
		private BundleRepository bundleRepo;
		
		//find all
		public List<Bundle> allBundles(){
			return bundleRepo.findAll();
		}
		//create
		public Bundle createBundle(Bundle bundle) {
			return bundleRepo.save(bundle);
		}
		//update/edit
		public Bundle editBundle(Bundle bundle) {
			return bundleRepo.save(bundle);
		}
		//find one
		public Bundle oneBundle(Long id) {
			Optional<Bundle> optionalBundle = bundleRepo.findById(id);
			if (optionalBundle.isPresent()) {
				return optionalBundle.get();
			}
			else {
				return null;
			}
		}
		//delete
		public void deleteBundle (Long id) {
			bundleRepo.deleteById(id);
		}
}
