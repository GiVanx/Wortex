import './App.js'
import React from 'react'
import ReactDOM from 'react-dom'
import { ThemeProvider } from '@material-ui/styles'
import App from './App'
import theme from './theme'

const WORDS = [
    {id:"1", value: "gegen"}, 
    {id:"2", value: "wand"}, 
    {id:"3", value: "aufstehen"}, 
    {id:"4", value: "sehen"}]

ReactDOM.render(
    <ThemeProvider theme={theme}>
        <App words={WORDS}/>
    </ThemeProvider>,
    document.getElementById('content')
)