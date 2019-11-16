package br.com.quintoandar.sakuraerrorcaptor.controller;

import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.TrackedSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/trackedSystem")
public class TrackedSystemController {

    @Autowired
    private TrackedSystemService _trackedSystemService;
}
