// @flow

import React from 'react';
import Container from '@material-ui/core/Container'
import { Input, IconButton, Paper } from '@material-ui/core';
import { makeStyles } from '@material-ui/styles'

import AddCircleOutlineOutlinedIcon from '@material-ui/icons/AddCircleOutlineOutlined';
import TranslateIcon from '@material-ui/icons/Translate';
import DeleteIcon from '@material-ui/icons/Delete';

import List from '@material-ui/core/List'
import ListItemText from '@material-ui/core/ListItemText'
import ListItem from '@material-ui/core/ListItem'
import Grid from "@material-ui/core/Grid"
import DefinitionDialog from './TranslationDialog';
import FilterPopover from './FilterPopover'

import type {WordDTO, TranslationDTO} from "./Types.js"

type WordInputProps = 
{
  filterOptions:string[],
  onAddNewWord: (word : string) => void
};

type WordInputState = {
  currentInputText: string
};

class WordInput extends React.Component<WordInputProps, WordInputState> {

  state = {
    currentInputText: ''
  }

  onInputTextChange = (value) => {
    let state = this.state
    state.currentInputText = value.target.value
    this.setState(state)
  }

  onAddNewWordButtonClick = () => {
    this.props.onAddNewWord(this.state.currentInputText)
  }

  render() {
    return (
      <React.Fragment>
        <Grid item xs={10}>
          <Input placeholder="Neu wort" fullWidth onChange={this.onInputTextChange} />
        </Grid>
        <Grid item xs={1}>
          <IconButton onClick={this.onAddNewWordButtonClick}>
            <AddCircleOutlineOutlinedIcon color="primary"  />
          </IconButton>
        </Grid>
        <Grid item xs={1}>
          <FilterPopover filterOptions={this.props.filterOptions}></FilterPopover>
        </Grid>
      </React.Fragment>
    )
  }
}

type WordsListType = {
  onTranslate: (word: string) => void,
  onDeleteWord: (word: string) => void,
  words: WordDTO[]
}

class WordsList extends React.Component<WordsListType> {

  onTranslateButtonClick = (word) => {
    this.props.onTranslate(word);
  }

  onDeleteWordButtonClick = (word) => {
    this.props.onDeleteWord(word);
  }

  render() {
    const rows = []

    this.props.words.forEach(wordDto => {
      rows.push(
      <ListItem key={wordDto.word} divider>
        <Grid container alignItems='center' spacing='1'>
          <Grid item xs={10}>
            {wordDto.word}
          </Grid>
          <Grid item xs={1}>
            <IconButton onClick={() => this.onTranslateButtonClick(wordDto.word)}>
              <TranslateIcon color='primary'></TranslateIcon>
            </IconButton>
          </Grid>
          <Grid item xs={1}>
            <IconButton onClick={() => this.onDeleteWordButtonClick(wordDto.word)}>
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

type AppProps = {
  words: WordDTO[],
  definitionDialogOpened: boolean,
  translation: TranslationDTO
}

export default function App (props : AppProps) {

  const SERVER_ADDRESS = "http://localhost:8080";
  const TRANSLATE_ENDPOINT = SERVER_ADDRESS + "/translate";

  const [words, setWords] = React.useState(props.words);
  const [definitionDialogOpened, setOpenDefinitionDialog] = React.useState(false);
  const [translation, setTranslation] = React.useState({});

  //TODO: The filter options should be obtained from the backend
  const filterOptions = [
    'Newest', 'Oldest', 'Alphabetical'
  ]

  function onAddNewWord(newWord) {

    // TODO: to be implemented
  }

  function onDeleteWord(word) {

    // TODO: to be implemented
  }

  function onCloseDefinitionDialog() {
    setOpenDefinitionDialog(false);
  }

  function onTranslateWord(word) {

    console.log("Endpoint: " + TRANSLATE_ENDPOINT + "/" + word);

    fetch(TRANSLATE_ENDPOINT + "/" + word)
      .then(res => res.json())
      .then((data) => {
        console.log("Endpoint response: " + data);
        setTranslation(data);
      })

    setOpenDefinitionDialog(true);
    console.log({definitionDialogOpened})
  }

  const classes = useStyles()

  return (
    <Container>
      <DefinitionDialog open={definitionDialogOpened} onClose={onCloseDefinitionDialog} translation={translation}></DefinitionDialog>
      <Grid container spacing={3} className={classes.searchGrid}>
        <Grid container item xs={12} spacing={0} alignItems='center'>
          <WordInput onAddNewWord={onAddNewWord} filterOptions={filterOptions}/>
        </Grid>
      </Grid>
      <WordsList onTranslate={onTranslateWord} onDeleteWord={onDeleteWord} words={words}/>
    </Container>
  );
}
