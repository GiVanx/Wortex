import './App.js'
import React from 'react'
import ReactDOM from 'react-dom'
import { ThemeProvider } from '@material-ui/styles'
import App from './App'
import theme from './theme'

const WORDS = [
    {pos: "verb", word: "gegen"}, 
    {pos:"verb", word: "wand"}, 
    {pos:"verb", word: "aufstehen"}, 
    {pos:"verb", word: "sehen"}]

ReactDOM.render(
    <ThemeProvider theme={theme}>
        <App words={WORDS}/>
    </ThemeProvider>,
    document.getElementById('content')
)