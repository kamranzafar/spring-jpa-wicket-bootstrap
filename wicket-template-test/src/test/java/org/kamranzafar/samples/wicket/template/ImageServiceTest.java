package org.kamranzafar.samples.wicket.template;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kamranzafar.samples.wicket.template.service.ServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.nio.file.Files;

/**
 * Created by kamran on 27/05/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:org/kamranzafar/samples/wicket/template/bean-locations.xml"})
public class ImageServiceTest {
    @Autowired
    private ServiceFacade serviceFacade;

    @Test
    public void getImage(){
        serviceFacade.getImageService().getImage(1);
    }

    @Test
    public void saveImage() throws Exception{
        Image image = new Image();
        image.setData(Files.readAllBytes(new File("/home/kamran/Downloads/Dragon.jpg").toPath()));
        image.setName("test_image");

        serviceFacade.getImageService().saveImage(image);
    }

    @Test
    public void getAllImages(){
        Assert.assertTrue(serviceFacade.getImageService().getAllImages().size() > 0);
    }
}
