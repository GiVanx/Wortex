import React from 'react';
import Container from '@material-ui/core/Container'
import { Input, IconButton, Paper } from '@material-ui/core';
import AddCircleOutlineOutlinedIcon from '@material-ui/icons/AddCircleOutlineOutlined';
import { makeStyles } from '@material-ui/styles'

import TranslateIcon from '@material-ui/icons/Translate';
import DeleteIcon from '@material-ui/icons/Delete';

import List from '@material-ui/core/List'
import ListItemText from '@material-ui/core/ListItemText'
import ListItem from '@material-ui/core/ListItem'
import Grid from "@material-ui/core/Grid"
import DefinitionDialog from './DefinitionDialog';

/*
> App
  > WordInput
  > WordsList
    >> WordsListRow
*/
const uuidv1 = require('uuid/v1')

class WordInput extends React.Component {

  state = {
    currentInputText: ''
  }

  onInputTextChange = (value) => {
    let state = this.state
    state.currentInputText = value.target.value
    this.setState(state)
  }

  onAddNewWordButtonClick = () => {
    this.props.onAddNewWord({ id: uuidv1(), value: this.state.currentInputText })
  }

  render() {
    return (
      <React.Fragment>
        <Grid item xs={11}>
          <Input placeholder="Neu wort" fullWidth onChange={this.onInputTextChange} />
        </Grid>
        <Grid item xs={1}>
          <IconButton aria-label="addNewWord" onClick={this.onAddNewWordButtonClick}>
            <AddCircleOutlineOutlinedIcon color="primary"  />
          </IconButton>
        </Grid>
      </React.Fragment>
    )
  }
}

class WordsList extends React.Component {

  onTranslateButtonClick = (word) => {
    console.log('onTranslateButtonClick()')
    this.props.onTranslate(word);
  }

  onDeleteWordButtonClick = (word) => {
    this.props.onDeleteWord(word);
  }

  render() {
    const rows = []

    this.props.words.forEach(word => {
      rows.push(
      <ListItem key={word.id} divider>
        <Grid container alignItems='center' spacing='1'>
          <Grid item xs={10}>
            {word.value}
          </Grid>
          <Grid item xs={1}>
            <IconButton onClick={() => this.onTranslateButtonClick(word)}>
              <TranslateIcon color='primary'></TranslateIcon>
            </IconButton>
          </Grid>
          <Grid item xs={1}>
            <IconButton onClick={() => this.onDeleteWordButtonClick(word)}>
              <DeleteIcon color='primary'></DeleteIcon>
            </IconButton>
          </Grid>
        </Grid>
      </ListItem>)
    });

    return (
      <Paper style={{ height:'90%', overflow: 'auto'}}>
        <List>{rows}</List>
      </Paper>
    )
  }
}

const useStyles = makeStyles({
  searchGrid: {
    marginBottom: 1
  }
});

export default function App (props) {

  // one weird thing to note:
  // for some reason, even though props.words is passed as an array, 
  // the state 'words' becomes an object: { words: Array(x) }
  const [words, setWords] = React.useState(props.words);
  const [definitionDialogOpened, setOpenDefinitionDialog] = React.useState(false);
  const [wordToTranslate, setWordToTranslate] = React.useState("");

  function onAddNewWord(newWord) {

    let newwords = [...{words}.words, newWord];
    setWords(newwords)
  }

  function onDeleteWord(word) {

    setWords({words}.words.filter(w => w.id !== word.id));
  }

  function onCloseDefinitionDialog() {
    setOpenDefinitionDialog(false);
  }

  function onTranslateWord(word) {
    console.log('onTranslateWord()')
    setWordToTranslate(word);
    setOpenDefinitionDialog(true);
    console.log({definitionDialogOpened})
  }

  const classes = useStyles()

  return (
    <Container>
      <DefinitionDialog open={definitionDialogOpened} onClose={onCloseDefinitionDialog} word={wordToTranslate}></DefinitionDialog>
      <Grid container spacing={3} className={classes.searchGrid}>
        <Grid container item xs={12} spacing={0} alignItems='center'>
          <WordInput onAddNewWord={onAddNewWord} />
        </Grid>
      </Grid>
      <WordsList onTranslate={onTranslateWord} onDeleteWord={onDeleteWord} words={words} />
    </Container>
  );
}