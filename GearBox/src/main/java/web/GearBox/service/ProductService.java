package web.GearBox.service;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import web.GearBox.model.Product;
import web.GearBox.repository.ProductRepo;


@Service
public class ProductService {

	private ProductRepo repo;

	public ProductService(ProductRepo repo) {
		super();
		this.repo = repo;
	}

	public List<Product> getAllProducts() {
		return repo.findAll();

	}

	public Product getProductById(int id) {
		return repo.findById(id).orElse(null);

	}

	public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
		product.setImageName(imageFile.getOriginalFilename());
		product.setImageType(imageFile.getContentType());
		product.setImageDate(imageFile.getBytes());
		return repo.save(product);
	}

	public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
		product.setImageDate(imageFile.getBytes());
		product.setImageName(imageFile.getOriginalFilename());
		product.setImageType(imageFile.getContentType());
		return repo.save(product);

	}

	public void deleteProductById(int id) {
		repo.deleteById(id);
	}

	public List<Product> searchProducts(String keyword) {
		// TODO Auto-generated method stub
		return repo.searchProducts(keyword);
	}

}
