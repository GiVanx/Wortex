import React, { useEffect } from 'react';
import Dialog from '@material-ui/core/Dialog';
// import { DialogTitle } from '@material-ui/core';
import Grid from '@material-ui/core/Grid';
import { DialogContent, AppBar, Typography } from '@material-ui/core';
import DialogContentText from '@material-ui/core/DialogContentText';
import IconButton from '@material-ui/core/IconButton'
import CloseIcon from '@material-ui/icons/Close'
import Toolbar from '@material-ui/core/Toolbar'
import { makeStyles } from '@material-ui/core/styles'
import Definition from './Definition'

export default function DefinitionDialog(props) {

    const [open, setOpen] = React.useState(false);
    const [translation, setTranslation] = React.useState(undefined);

    useEffect(() => {
        console.log("open = " + props.open);
        setOpen(props.open)
        setTranslation(props.translation)
    }, [props])

    const useStyles = makeStyles(theme => ({
        word: {
            marginLeft: theme.spacing(2),
            flex: 1
        },
        appBar: {
            position: 'relative'
        },
        header: {
            // set marginTop such that the word
            // is at the same level with the close button
            // in Toolbar component
            marginTop: theme.spacing(2),
            paddingBottom: theme.spacing(1)
        }
    }));

    const classes = useStyles();

    function PosAndTranscript() {
        return (
            <Grid item container direction="column" xs={3} alignItems="center">
                <Grid item xs={6}>
                    {props.translation.pos}
                </Grid>
                <Grid item xs={6}>
                    {props.translation.transcript}
                </Grid>
            </Grid>
        )
    }

    function Header() {

        return (
            <Grid container className={classes.header}>
                <Grid item xs={9}>
                    <Typography variant="h5" className={classes.word}>
                        {props.translation.word}
                    </Typography>
                </Grid>
                <PosAndTranscript/>
            </Grid>
        )
    }

    var definitions = props.translation.definitions;

    return (
        <Dialog
            fullScreen
            open={open}
            onClose={props.onClose}>
                <AppBar className={classes.appBar}>
                    <Toolbar>
                        <IconButton edge="start" onClick={() => props.onClose()}>
                            <CloseIcon/>
                        </IconButton>
                        <Header />
                    </Toolbar>
                </AppBar>
                { (definitions !== undefined) && definitions.map(d => <Definition definition={d}/>) }
        </Dialog>
    )
}