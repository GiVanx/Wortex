import React, { useEffect } from 'react'
import Dialog from '@material-ui/core/Dialog'
import { DialogTitle } from '@material-ui/core';

export default function DefinitionDialog(props) {

    const [open, setOpen] = React.useState(false);
    const [word, setWord] = React.useState('');

    useEffect(() => {
        console.log('DefinitionDialog props changed')
        setOpen(props.open)
        setWord(props.word)
    }, [props])

    return (
        <Dialog
            open={open}
            onClose={props.onClose}
            scroll='body'>
                <DialogTitle>{word.value}</DialogTitle>
        </Dialog>
    )

}