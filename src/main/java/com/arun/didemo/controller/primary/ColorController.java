package com.arun.didemo.controller.primary;

import com.arun.didemo.service.primary.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ColorController {
    private Color color;
    private Color purple;

    @Autowired
    public ColorController(Color color, @Qualifier("purple") Color purple) {
        this.color = color;
        this.purple = purple;
    }

    public void getColor() {
        color.color();
    }

    public void getPurple() {
        purple.color();
    }
}
