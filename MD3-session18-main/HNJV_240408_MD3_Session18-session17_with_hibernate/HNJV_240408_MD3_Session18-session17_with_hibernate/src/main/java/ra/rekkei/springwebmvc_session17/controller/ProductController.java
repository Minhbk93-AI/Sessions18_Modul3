package ra.rekkei.springwebmvc_session17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ra.rekkei.springwebmvc_session17.model.entity.Product;
import ra.rekkei.springwebmvc_session17.model.entity.ProductImage;
import ra.rekkei.springwebmvc_session17.service.ProductImageService;
import ra.rekkei.springwebmvc_session17.service.ProductService;
import ra.rekkei.springwebmvc_session17.service.impl.ProductImageServiceImpl;
import ra.rekkei.springwebmvc_session17.service.impl.ProductServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

@RequestMapping
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductImageService productImageService;

    @RequestMapping(value = {"/", "/loadProducts"})
    public String home(Model model) {
        List<Product> list = productService.findAll();
        model.addAttribute("list", list);
        return "home";
    }

    @RequestMapping("/initInsertProduct")
    public String initInsertProduct(Model model) {
        Product p = new Product();
        model.addAttribute("p", p);
        return "insertProduct";
    }

    @RequestMapping("/insertProduct")
    public String insertProduct(@Valid @ModelAttribute("p") Product pro, BindingResult result, @RequestParam("primaryImage") MultipartFile filePrimary, @RequestParam("secondaryImages") MultipartFile[] listSecondImages, Model model) {
        String imageUrl = "D:\\apache-tomcat-9.0.45\\webapps\\product_app\\resources\\images\\";
        String imageUrlLocal = "D:\\RIKKEI\\HNJV_240408\\MD03\\Session 17\\springwebmvc_session17\\src\\main\\webapp\\resources\\images\\";

        if (result.hasErrors()) {
            model.addAttribute("p", pro);
            return "insertProduct";
        } else {
            String primaryImageName = filePrimary.getOriginalFilename();
            if (!filePrimary.isEmpty()) {
                //upload anh chinh
                File f_primary = new File(imageUrl + "/" + primaryImageName);
                if (!f_primary.exists()) {
                    try {
                        Files.write(f_primary.toPath(), filePrimary.getBytes(), StandardOpenOption.CREATE_NEW);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                //upload len local:
                File local = new File(imageUrlLocal+"/"+primaryImageName);
                if(!local.exists()){
                    try {
                        Files.write(local.toPath(), filePrimary.getBytes(), StandardOpenOption.CREATE_NEW);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            pro.setImageName(primaryImageName);
        }


        //save dl product vao bang products trong database
        boolean blSave = productService.save(pro);
        if (blSave) {
            if (listSecondImages != null && listSecondImages.length > 0) {
                //upload anh phu
                for (MultipartFile file : listSecondImages) {
                    String imageName = file.getOriginalFilename();
                    File f = new File(imageUrl + "/" + imageName);
                    //upload len tomcat server
                    if (!f.exists()) {
                        try {
                            Files.write(f.toPath(), file.getBytes(), StandardOpenOption.CREATE_NEW);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    //upload len local:
                    File local = new File(imageUrlLocal+"/"+imageName);
                    if(!local.exists()){
                        try {
                            Files.write(local.toPath(), filePrimary.getBytes(), StandardOpenOption.CREATE_NEW);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    ProductImage pimage = new ProductImage();
                    pimage.setProduct(pro);
                    pimage.setImageName(imageName);
                    productImageService.save(pimage);
                }
            }
            return "redirect:/loadProducts";  // Goi lai ham trong controller
        } else {
            model.addAttribute("error", "Insert failed!");
            model.addAttribute("p", pro);
            return "insertProduct";
        }
    }
}

