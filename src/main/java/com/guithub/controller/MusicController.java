package com.guithub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
public class MusicController {
    @RequestMapping(value = "/music", method = RequestMethod.GET)
    String getMusic() {

        return "music";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    String uploadXML(@RequestParam(value = "file1") MultipartFile file1,
                     @RequestParam(value = "file2") MultipartFile file2) {
        String name1 = "sample1.xml";
        String name2 = "sample2.xml";
        if (!file1.isEmpty() && !file2.isEmpty()) {
            try {
                byte[] bytes = file1.getBytes();
                BufferedOutputStream stream =
                    new BufferedOutputStream(
                        new FileOutputStream(new File("build\\resources\\main\\static\\" + name1)));
                stream.write(bytes);
                stream.close();

                byte[] bytes2 = file2.getBytes();
                BufferedOutputStream stream2 =
                    new BufferedOutputStream(
                        new FileOutputStream(
                            new File("build\\resources\\main\\static\\" + name2)));
                stream2.write(bytes2);
                stream2.close();

                return "redirect:/music";
            } catch (Exception exeption) {
                return "redirect:/music";
            }
        } else {
            return "redirect:/music";
        }
    }
}
