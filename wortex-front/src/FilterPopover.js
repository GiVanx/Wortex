import React from 'react'
import {
    usePopupState, bindPopover
} from 'material-ui-popup-state/hooks'
import { bindTrigger } from 'material-ui-popup-state/core'
import { Popover } from '@material-ui/core'
import FilterListIcon from '@material-ui/icons/FilterList';
import { IconButton} from '@material-ui/core';
import List from '@material-ui/core/ListItem';
import ListItem from '@material-ui/core/ListItem';
import { makeStyles } from '@material-ui/styles'

const useStyles = makeStyles({
    filterListItem: {
      paddingTop: 0,
      paddingBottom: 0
    }
  });

function FilterPopover(props) {

    const popupState = usePopupState({
        variant: 'popover',
        popupId: 'filterPopover'
    })

    const classes = useStyles()

    return (
        <div>
            <IconButton variant="contained" {...bindTrigger(popupState)}>
                <FilterListIcon color="primary" />
            </IconButton>
            <Popover
                {...bindPopover(popupState)}
                anchorOrigin={{
                    vertical: 'bottom',
                    horizontal: 'center',
                  }}
                  transformOrigin={{
                    vertical: 'top',
                    horizontal: 'center',
                  }}
            >
                <List>
                    {props.filterOptions.map(l => <ListItem button className={classes.filterListItem}>{l}</ListItem>)}
                </List>
            </Popover>
        </div>
    )
}

export default FilterPopover;