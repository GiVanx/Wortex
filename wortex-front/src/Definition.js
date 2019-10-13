import React from 'react'
import Typography from '@material-ui/core/Typography'
import {makeStyles} from '@material-ui/core/styles'

import ExpansionPanel from '@material-ui/core/ExpansionPanel'
import ExpansionPanelSummary from '@material-ui/core/ExpansionPanelSummary'
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import ExpansionPanelDetails from '@material-ui/core/ExpansionPanelDetails'

const useStyles = makeStyles(theme => ({

    mainSynonym: {
        flexGrow: 2,
        flexShrink: 0
    },
    mainSynonymPos: {
        color: theme.palette.text.secondary,
        flexShrink: 0,
        flexGrow: 0
    }
}));   

export default function Definition(props) {

    var classes = useStyles();

    return (
        <ExpansionPanel>
                <ExpansionPanelSummary
                    expandIcon={<ExpandMoreIcon />}>
                    <Typography className={classes.mainSynonym}>{ props.definition.synonyms[0].text }</Typography>
                    <Typography className={classes.mainSynonymPos}>{ props.definition.synonyms[0].pos }</Typography>
                </ExpansionPanelSummary>
                <ExpansionPanelDetails>
                
                </ExpansionPanelDetails>
        </ExpansionPanel>
    );
}