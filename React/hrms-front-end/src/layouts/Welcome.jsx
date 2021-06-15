import React, { useState } from 'react';
import { Nav, NavItem, NavLink } from 'reactstrap';

 
export default function Welcome(props) {

    const Example = (props) => {
        return (
          <div>
            <p>List Based</p>
            <Nav>
              <NavItem>
                <NavLink href="#">Link</NavLink>
              </NavItem>
              <NavItem>
                <NavLink href="#">Link</NavLink>
              </NavItem>
              <NavItem>
                <NavLink href="#">Another Link</NavLink>
              </NavItem>
              <NavItem>
                <NavLink disabled href="#">Disabled Link</NavLink>
              </NavItem>
            </Nav>
            <hr />
            <p>Link Based</p>
            <Nav>
              <NavLink href="#">Link</NavLink> <NavLink href="#">Link</NavLink> <NavLink href="#">Another Link</NavLink> <NavLink disabled href="#">Disabled Link</NavLink>
            </Nav>
          </div>
        );
      }
}

