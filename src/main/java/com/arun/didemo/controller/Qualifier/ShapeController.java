package com.arun.didemo.controller.Qualifier;

import com.arun.didemo.service.qualifier.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ShapeController {

    private Shape shape;
    private Shape rectangle;
    private Shape square;

    @Autowired
    public ShapeController(@Qualifier("circle") Shape shape, Shape rectangle, Shape square) {
        this.shape = shape;
        this.rectangle = rectangle;
        this.square = square;
    }

    public void getShape() {
        shape.shape();
    }

    public void getRectangleShapeBasedOnType() {
        rectangle.shape();
    }

    public void getSquareBasedOnType() {
        square.shape();
    }
}
