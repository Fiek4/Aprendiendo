package com.example.jetpackcomposecatalogo


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun ConstraintExample1() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxBlue, boxMagenta, boxGreen, boxCyan) = createRefs()



        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)

            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                top.linkTo(boxRed.bottom)
                end.linkTo(boxRed.start)


            })
        Box(modifier = Modifier
                .size(125.dp)
                .background(Color.Cyan)
                .constrainAs(boxCyan) {
                    start.linkTo(boxRed.end)
                    top.linkTo(boxRed.bottom)
                })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                bottom.linkTo(boxRed.top)
                end.linkTo(boxRed.start)

            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                bottom.linkTo(boxRed.top)
                start.linkTo(boxRed.end)
            })



    }
}


@Composable
fun ConstraintExampleGuide() {
    ConstraintLayout(Modifier.fillMaxSize()) {

        val boxRed = createRef()
        val topGuide = createGuidelineFromTop(0.1f)
        val startGuide = createGuidelineFromStart(0.25f)


        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(topGuide)
                start.linkTo(startGuide)
            })

    }
}


@Composable
fun ConstraintBarrier() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxRed, boxGreen, boxCyan) = createRefs()
        val barrier = createEndBarrier(boxCyan,boxGreen)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                start.linkTo(parent.start, margin = 16.dp)


            })
        Box(modifier = Modifier
            .size(325.dp)
            .background(Color.Cyan)
            .constrainAs(boxCyan) {
                top.linkTo(boxGreen.bottom)
                start.linkTo(parent.start, margin = 32.dp)

            })
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                start.linkTo(barrier)
            })


    }


}


