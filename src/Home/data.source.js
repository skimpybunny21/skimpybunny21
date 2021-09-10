import React, { Component } from 'react';
import Popup from '../Components/ModalLogin';



export const Nav30DataSource = {
  wrapper: { className: 'header3 home-page-wrapper ksyr20teb3-editor_css' },
  page: { className: 'home-page' },
  logo: {
    className: 'header3-logo ksyqidpda1n-editor_css',
    children: 'https://i.imgur.com/b30AEJI.png',
  },
  Menu: {
    className: 'header3-menu',
    children: [
      {
        name: 'item0',
        className: 'header3-item',
        children: {
          href: '#',
          children: [
            {
              children: (
                <span>
                  <span>
                    <p>How it works?</p>
                  </span>
                </span>
              ),
              name: 'text',
            },
          ],
        },
        subItem: [
          {
            name: 'sub0',
            className: 'item-sub',
            children: {
              className: 'item-sub-item',
              children: [
                {
                  name: 'image0',
                  className: 'item-image',
                  children:
                    'https://gw.alipayobjects.com/zos/rmsportal/ruHbkzzMKShUpDYMEmHM.svg',
                },
                {
                  name: 'title',
                  className: 'item-title',
                  children: 'Ant Design',
                },
                {
                  name: 'content',
                  className: 'item-content',
                  children: 'Test 1',
                  href:'/userpage'
                },
              ],
            },
          },
          {
            name: 'sub1',
            className: 'item-sub',
            children: {
              className: 'item-sub-item',
              children: [
                {
                  name: 'image0',
                  className: 'item-image',
                  children:
                    'https://gw.alipayobjects.com/zos/rmsportal/ruHbkzzMKShUpDYMEmHM.svg',
                },
                {
                  name: 'title',
                  className: 'item-title',
                  children: 'Ant Design',
                },
                {
                  name: 'content',
                  className: 'item-content',
                  children: 'Test 2',
                },
              ],
            },
          },
        ],
      },
      {
        name: 'item1',
        className: 'header3-item',
        children: {
          href: '#',
          children: [
            {
              children: (
                <span>
                  <span>
                    <p>Why SB</p>
                  </span>
                </span>
              ),
              name: 'text',
            },
          ],
        },
      },
      {
        name: 'item2',
        className: 'header3-item',
        children: {
          href: '#',
          children: [
            {
              children: (
                <span>
                  <span>
                    <p>Plans</p>
                  </span>
                </span>
              ),
              name: 'text',
            },
          ],
        },
      },
      {
        name: 'item3',
        className: 'header3-item',
        children: {
          href: '#',
          children: [
            {
              children: (
                <span>
                  <p>
                    <Popup></Popup>
                  </p>
                </span>
              ),
              name: 'text',
              className: 'ksys1i6iwyj-editor_css',
            },
          ],
        },
      },
    ],
  },
  mobileMenu: { className: 'header3-mobile-menu' },
};
export const Banner10DataSource = {
  wrapper: { className: 'banner1' },
  BannerAnim: {
    children: [
      {
        name: 'elem0',
        BannerElement: { className: 'banner-user-elem' },
        textWrapper: { className: 'banner1-text-wrapper' },
        bg: { className: 'bg bg0 ksys9io7up-editor_css' },
        title: {
          className: 'banner1-title ksysfaec75k-editor_css',
          children: 'https://i.imgur.com/Dp3xb0L.png',
        },
        content: {
          className: 'banner1-content ksys3zk6xh7-editor_css',
          children: (
            <span>
              <span>
                <span>
                  <span>
                    <p>
                      <b>
                        <i>A better way to see your budget</i>
                      </b>
                    </p>
                  </span>
                </span>
              </span>
            </span>
          ),
        },
        button: {
          className: 'banner1-button ksysdkiq8wj-editor_css',
          children: (
            <span>
              <p>Sign up for free</p>
            </span>
          ),
        },
      },
      {
        name: 'elem1',
        BannerElement: { className: 'banner-user-elem' },
        textWrapper: { className: 'banner1-text-wrapper' },
        bg: { className: 'bg bg1 ksytqnd6ab-editor_css' },
        title: {
          className: 'banner1-title',
          children: 'https://i.imgur.com/db1teVi.png',
        },
        content: {
          className: 'banner1-content',
          children: (
            <span>
              <p>I see here work to do....</p>
            </span>
          ),
        },
        button: { className: 'banner1-button', children: 'Learn More' },
      },
    ],
  },
};
export const Content00DataSource = {
  wrapper: {
    className: 'home-page-wrapper content0-wrapper ksysjiz3d4q-editor_css',
  },
  page: { className: 'home-page content0' },
  OverPack: { playScale: 0.3, className: '' },
  titleWrapper: {
    className: 'title-wrapper',
    children: [
      {
        name: 'title',
        children: (
          <span>
            <p>What is it all about?</p>
          </span>
        ),
      },
    ],
  },
  childWrapper: {
    className: 'content0-block-wrapper',
    children: [
      {
        name: 'block0',
        className: 'content0-block',
        md: 8,
        xs: 24,
        children: {
          className: 'content0-block-item',
          children: [
            {
              name: 'image',
              className: 'content0-block-icon',
              children:
                'https://zos.alipayobjects.com/rmsportal/WBnVOjtIlGWbzyQivuyq.png',
            },
            {
              name: 'title',
              className: 'content0-block-title',
              children: (
                <span>
                  <span>
                    <p>Manage your expenses</p>
                  </span>
                </span>
              ),
            },
            {
              name: 'content',
              children: (
                <span>
                  <p>Charges, subscriptions and more!</p>
                </span>
              ),
            },
          ],
        },
      },
      {
        name: 'block1',
        className: 'content0-block',
        md: 8,
        xs: 24,
        children: {
          className: 'content0-block-item',
          children: [
            {
              name: 'image',
              className: 'content0-block-icon',
              children:
                'https://zos.alipayobjects.com/rmsportal/YPMsLQuCEXtuEkmXTTdk.png',
            },
            {
              name: 'title',
              className: 'content0-block-title',
              children: (
                <span>
                  <p>Plan your budget</p>
                </span>
              ),
            },
            {
              name: 'content',
              children: (
                <span>
                  <p>You can improve your monthly cashflow!</p>
                </span>
              ),
            },
          ],
        },
      },
      {
        name: 'block2',
        className: 'content0-block',
        md: 8,
        xs: 24,
        children: {
          className: 'content0-block-item',
          children: [
            {
              name: 'image',
              className: 'content0-block-icon',
              children:
                'https://zos.alipayobjects.com/rmsportal/EkXWVvAaFJKCzhMmQYiX.png',
            },
            {
              name: 'title',
              className: 'content0-block-title',
              children: (
                <span>
                  <span>
                    <p>Clear visualization</p>
                  </span>
                </span>
              ),
            },
            {
              name: 'content',
              children: (
                <span>
                  <p>For You to respond even faster!</p>
                </span>
              ),
            },
          ],
        },
      },
    ],
  },
};
export const Pricing10DataSource = {
  wrapper: {
    className: 'home-page-wrapper pricing1-wrapper ksyu566zlh-editor_css',
  },
  page: { className: 'home-page pricing1' },
  OverPack: { playScale: 0.3, className: 'pricing1-content-wrapper' },
  titleWrapper: {
    className: 'pricing1-title-wrapper',
    children: [
      {
        name: 'title',
        children: (
          <span>
            <p>Pricing</p>
          </span>
        ),
        className: 'pricing1-title-h1',
      },
    ],
  },
  block: {
    className: 'pricing1-block-wrapper',
    children: [
      {
        name: 'block0',
        className: 'pricing1-block',
        md: 8,
        xs: 24,
        children: {
          wrapper: { className: 'pricing1-block-box  ksyu7hyd2v-editor_css' },
          topWrapper: { className: 'pricing1-top-wrapper' },
          name: { className: 'pricing1-name', children: 'Free' },
          money: {
            className: 'pricing1-money',
            children: (
              <span>
                <p>0 USD</p>
              </span>
            ),
          },
          content: {
            className: 'pricing1-content',
            children: (
              <span>
                <span>
                  <p>
                    Option 1<br />Option 2<br />Option 3<br />
                  </p>
                </span>
              </span>
            ),
          },
          line: { className: 'pricing1-line' },
          buttonWrapper: {
            className: 'pricing1-button-wrapper',
            children: {
              a: {
                className: 'pricing1-button',
                href: '#',
                children: (
                  <span>
                    <p>Get starter</p>
                  </span>
                ),
              },
            },
          },
        },
      },
      {
        name: 'block1',
        className: 'pricing1-block',
        md: 8,
        xs: 24,
        children: {
          wrapper: { className: 'pricing1-block-box active' },
          topWrapper: { className: 'pricing1-top-wrapper' },
          name: { className: 'pricing1-name', children: 'Starter' },
          money: {
            className: 'pricing1-money',
            children: (
              <span>
                <p>4.99 USD</p>
              </span>
            ),
          },
          content: {
            className: 'pricing1-content',
            children: (
              <span>
                <span>
                  <span>
                    <p>
                      Option 1<br />Option 2<br />Option 3<br />Option 4<br />Option
                      5<br />
                    </p>
                  </span>
                </span>
              </span>
            ),
          },
          line: { className: 'pricing1-line' },
          buttonWrapper: {
            className: 'pricing1-button-wrapper',
            children: {
              a: {
                className: 'pricing1-button',
                href: '#',
                children: (
                  <span>
                    <p>Choose Starter</p>
                  </span>
                ),
              },
            },
          },
        },
      },
      {
        name: 'block2',
        className: 'pricing1-block',
        md: 8,
        xs: 24,
        children: {
          wrapper: { className: 'pricing1-block-box  ksyu7a345th-editor_css' },
          topWrapper: { className: 'pricing1-top-wrapper' },
          name: { className: 'pricing1-name', children: 'Pro' },
          money: {
            className: 'pricing1-money',
            children: (
              <span>
                <p>9.99 USD</p>
              </span>
            ),
          },
          content: {
            className: 'pricing1-content',
            children: (
              <span>
                <p>
                  Option 1&nbsp;<br />Option 2<br />Option 3<br />Option 4<br />Option
                  5<br />Option 6<br />
                </p>
              </span>
            ),
          },
          line: { className: 'pricing1-line' },
          buttonWrapper: {
            className: 'pricing1-button-wrapper',
            children: {
              a: {
                className: 'pricing1-button',
                href: '#',
                children: (
                  <span>
                    <p>Choose Pro</p>
                  </span>
                ),
              },
            },
          },
        },
      },
    ],
  },
};
export const Footer10DataSource = {
  wrapper: { className: 'home-page-wrapper footer1-wrapper' },
  OverPack: { className: 'footer1', playScale: 0.2 },
  block: {
    className: 'home-page',
    gutter: 0,
    children: [
      {
        name: 'block0',
        xs: 24,
        md: 6,
        className: 'block',
        title: {
          className: 'logo',
          children: 'https://i.imgur.com/db1teVi.png',
        },
        childWrapper: {
          className: 'slogan',
          children: [
            {
              name: 'content0',
              children: (
                <span>
                  <span>
                    <p>dev</p>
                  </span>
                </span>
              ),
            },
          ],
        },
      },
      {
        name: 'block1',
        xs: 24,
        md: 6,
        className: 'block',
        title: {
          children: (
            <span>
              <span>
                <p>Product</p>
              </span>
            </span>
          ),
        },
        childWrapper: {
          children: [
            {
              name: 'link0',
              href: '#',
              children: (
                <span>
                  <span>
                    <p>Why Skimpy Bunny</p>
                  </span>
                </span>
              ),
            },
            {
              name: 'link1',
              href: '#',
              children: (
                <span>
                  <span>
                    <p>Compare Plans</p>
                  </span>
                </span>
              ),
            },
            {
              name: 'link2',
              href: '#',
              children: (
                <span>
                  <p>Free version</p>
                </span>
              ),
            },
            {
              name: 'link3',
              href: '#',
              children: (
                <span>
                  <p>Integration</p>
                </span>
              ),
            },
          ],
        },
      },
      {
        name: 'block2',
        xs: 24,
        md: 6,
        className: 'block',
        title: {
          children: (
            <span>
              <p>Support</p>
            </span>
          ),
        },
        childWrapper: {
          children: [
            { href: '#', name: 'link0', children: 'FAQ' },
            {
              href: '#',
              name: 'link1',
              children: (
                <span>
                  <span>
                    <p>Help &amp; Troubleshooting</p>
                  </span>
                </span>
              ),
            },
          ],
        },
      },
      {
        name: 'block3',
        xs: 24,
        md: 6,
        className: 'block',
        title: {
          children: (
            <span>
              <p>Design</p>
            </span>
          ),
        },
        childWrapper: {
          children: [
            { href: '#', name: 'link0', children: 'Ant Design' },
            { href: '#', name: 'link1', children: 'Ant Motion' },
          ],
        },
      },
    ],
  },
  copyrightWrapper: { className: 'copyright-wrapper' },
  copyrightPage: { className: 'home-page' },
  copyright: {
    className: 'copyright',
    children: (
      <span>
        <span>©2021 by Skimpy Bunny Company&nbsp;All Rights Reserved</span>
      </span>
    ),
  },
};
