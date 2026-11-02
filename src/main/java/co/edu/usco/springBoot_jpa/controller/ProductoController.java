package co.edu.usco.springBoot_jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.usco.springBoot_jpa.model.Producto;
import co.edu.usco.springBoot_jpa.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping
	public String getAllProductos(Model model) {
		model.addAttribute("productos", productoService.getAllProductos());
		return "lista-productos";
	}

	@GetMapping("/nuevo")
	public String mostrarFormularioNuevoProducto(Model model) {
		model.addAttribute("producto", new Producto());
		return "nuevo-producto";
	}

	@PostMapping("/guardar")
	public String guardarProducto(@ModelAttribute Producto producto) {
		productoService.createProducto(producto);
		return "redirect:/productos";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEditarProducto(@PathVariable Long id, Model model) {
		Producto producto = productoService.getProductoById(id).orElseThrow();
		model.addAttribute("producto", producto);
		return "editar-producto";
	}

	@PostMapping("/actualizar/{id}")
	public String actualizarProducto(@PathVariable Long id, @ModelAttribute Producto producto) {
		productoService.updateProducto(id, producto);
		return "redirect:/productos";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable Long id) {
		productoService.deleteProducto(id);
		return "redirect:/productos";
	}

}
